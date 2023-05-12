package cj.geochat.server.gateway.config;

import cj.geochat.ability.oauth2.gateway.ICheckPermission;
import cj.geochat.ability.oauth2.gateway.annotation.EnableCjOAuth2Gateway;
import cj.geochat.ability.oauth2.gateway.config.SecurityWorkbin;
import cj.geochat.ability.redis.annotation.EnableCjRedis;
import org.springframework.context.annotation.Configuration;

@EnableCjOAuth2Gateway
@EnableCjRedis
@Configuration
public class GatewaySecurityWorkbin extends SecurityWorkbin {
    @Override
    protected ICheckPermission createCheckPermission() {
        //所有中台的服务一律拦截掉，网关只充许geochat app通过，
        return (antPathMatcher, role, accessUrl) ->
                !antPathMatcher.match("/cj-geochat-middle-*/*/**",accessUrl);
    }
}
