package cj.geochat.server.asc.config;

import cj.geochat.ability.api.annotation.EnableCjApi;
import cj.geochat.ability.oauth2.asc.annotation.EnableCjAsc;
import cj.geochat.ability.swagger.annotation.EnableCjSwagger;
import org.springframework.context.annotation.Configuration;

@EnableCjApi
@EnableCjSwagger
@Configuration
public class OpenApiConfig {
}
