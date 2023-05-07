package cj.geochat.server.authorization.config;

import cj.geochat.ability.oauth2.annotation.EnableCjOAuth2Server;
import cj.geochat.ability.oauth2.config.SecurityWorkbin;
import cj.geochat.ability.redis.annotation.EnableCjRedis;
import cj.geochat.server.authorization.workbin.ExampleClientDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;

@EnableCjRedis
@EnableCjOAuth2Server
@Configuration
public class ServerSecurityWorkbin extends SecurityWorkbin {
    @Override
    public ClientDetailsService clientDetailsService() {
        return new ExampleClientDetailsService();
    }
}
