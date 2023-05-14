package cj.geochat.server.authorization.config;

import cj.geochat.ability.feign.annotation.EnableCjFeign;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableCjFeign
@EnableFeignClients(basePackages = "cj.geochat.server.authorization.remote")
@Configuration
public class OpenFeignConfig {
}
