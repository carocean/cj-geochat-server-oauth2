package cj.geochat.server.gateway.config;

import cj.geochat.ability.oauth2.gateway.annotation.EnableCjOAuth2Gateway;
import cj.geochat.ability.oauth2.gateway.config.SecurityWorkbin;
import cj.geochat.ability.redis.annotation.EnableCjRedis;
import org.springframework.context.annotation.Configuration;

@EnableCjOAuth2Gateway
@EnableCjRedis
@Configuration
public class GatewaySecurityWorkbin extends SecurityWorkbin {
}
