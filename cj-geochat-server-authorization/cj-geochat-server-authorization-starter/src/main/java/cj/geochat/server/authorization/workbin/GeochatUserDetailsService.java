package cj.geochat.server.authorization.workbin;

import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.UserStatus;
import cj.geochat.server.authorization.remote.UserDetailsRemote;
import cj.geochat.server.authorization.userdetails.GeochatUser;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GeochatUserDetailsService implements UserDetailsService {
    @Autowired
    UserDetailsRemote userDetailsRemote;

    Pattern phone = Pattern.compile("1[3-9]\\d{9}");
    Pattern email = Pattern.compile("\\w{1,30}@[a-zA-Z0-9]{2,20}(\\.[a-zA-Z0-9]{2,20}){1,2}");

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginAccountCategory category = parseCategory(username);
        cj.geochat.middle.uc.UserDetails userDetails = userDetailsRemote.loadUserDetailsByAccount(category, username);
        if (userDetails == null) {
            throw new UsernameNotFoundException(username);
        }
        return convertUserDetails(username, userDetails);
    }

    private UserDetails convertUserDetails(String openCode, cj.geochat.middle.uc.UserDetails userDetails) {
        var state = userDetails.getStatus() == UserStatus.normal ? true : false;
        GeochatUser user = new GeochatUser(openCode, userDetails.getId(), userDetails.getPassword(), state, true, true, true,
                userDetails.getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList())
        );
        return user;
    }

    private LoginAccountCategory parseCategory(String username) {
        if (phone.matcher(username).matches()) {
            return LoginAccountCategory.phone;
        }
        if (email.matcher(username).matches()) {
            return LoginAccountCategory.email;
        }
        return LoginAccountCategory.geochat;
    }
}
