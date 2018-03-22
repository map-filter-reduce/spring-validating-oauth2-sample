package sample.config;

import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class ValidatingUserService extends OidcUserService {

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {

        // get user from OidcUserService
        OidcUser user = super.loadUser(userRequest);

        // perform some validation
        String allowedEmail = "albus.percival.wulfric.brian.dumbledore@hogwarts.co.uk";

        if (allowedEmail.equals(user.getEmail()) &&
                Boolean.TRUE.equals(user.getEmailVerified())) {

            // return the user if validation is passed
            return user;
        } else {

            // throw OAuth2AuthenticationException if validation fails
            throw new OAuth2AuthenticationException(
                    new OAuth2Error("email_not_allowed"),
                    "Email not allowed!");
        }
    }
}
