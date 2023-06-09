package cj.geochat.server.authorization.config;

import cj.geochat.ability.oauth2.annotation.EnableCjOAuth2Server;
import cj.geochat.ability.oauth2.config.SecurityWorkbin;
import cj.geochat.ability.redis.annotation.EnableCjRedis;
import cj.geochat.server.authorization.remote.AppDetailsRemote;
import cj.geochat.server.authorization.remote.UserDetailsRemote;
import cj.geochat.server.authorization.workbin.ExampleClientDetailsService;
import cj.geochat.server.authorization.workbin.ExampleUserDetailsService;
import cj.geochat.server.authorization.workbin.GeochatClientDetailsService;
import cj.geochat.server.authorization.workbin.GeochatUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;

@EnableCjRedis
@EnableCjOAuth2Server
@Configuration
public class ServerSecurityWorkbin extends SecurityWorkbin {

    @Override
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        return new ExampleUserDetailsService(passwordEncoder);
        return new GeochatUserDetailsService();
    }

    @Override
    public ClientDetailsService clientDetailsService() {
//        return new ExampleClientDetailsService();
        return new GeochatClientDetailsService();
    }
}
