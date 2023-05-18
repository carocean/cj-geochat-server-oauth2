package cj.geochat.server.authorization.userdetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class GeochatUser extends User implements IUserDetails {
    private static final long serialVersionUID = 1L;
    String openCode;

    public GeochatUser(String openCode, String userId, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(userId, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.openCode=openCode;
    }

    public GeochatUser(String openCode, String userId, String password, Collection<? extends GrantedAuthority> authorities) {
        super(userId, password, authorities);
        this.openCode=openCode;
    }

    @Override
    public String getOpenCode() {
        return openCode;
    }
}
