package cj.geochat.app.test.config;

import cj.geochat.ability.oauth2.app.annotation.EnableCjOAuth2App;
import cj.geochat.ability.oauth2.app.config.AppSecurityWorkbin;
import org.springframework.context.annotation.Configuration;

@EnableCjOAuth2App
@Configuration
public class MyAppSecurityWorkbin extends AppSecurityWorkbin {
}
