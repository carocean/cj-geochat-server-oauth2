package cj.geochat.app.test.config;

import cj.geochat.ability.feign.annotation.EnableCjFeign;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackages = "cj.geochat.app.test")
@EnableCjFeign
@Configuration
public class OpenFeignConfig {
}
