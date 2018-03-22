package sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated();

        // set custom user service for openid connect providers
        http.oauth2Login()
                .userInfoEndpoint()
                .oidcUserService(new ValidatingUserService());

        // set custom user service for pure oauth2 providers
//        http.oauth2Login()
//                .userInfoEndpoint()
//                .userService(...);

    }

}
