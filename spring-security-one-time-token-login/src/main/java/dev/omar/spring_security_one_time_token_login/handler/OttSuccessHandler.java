package dev.omar.spring_security_one_time_token_login.handler;


import dev.omar.spring_security_one_time_token_login.service.OneTimeTokenMailNotifier;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.ott.OneTimeToken;
import org.springframework.security.web.authentication.ott.OneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.authentication.ott.RedirectOneTimeTokenGenerationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

import static dev.omar.spring_security_one_time_token_login.common.EmailTemplates.ONE_TIME_TOKEN;

/**
 * Handles the successful generation of a One-Time Token (OTT) for a user.
 * <p>
 * When a one-time token is generated, this handler is responsible for:
 * <ul>
 *     <li>Sending the token to the user's email via {@link OneTimeTokenMailNotifier}.</li>
 *     <li>Redirecting the user to a confirmation page after sending the email.</li>
 * </ul>
 * Implements {@link OneTimeTokenGenerationSuccessHandler} to integrate with the OTT login flow.
 */
@Component
public class OttSuccessHandler implements OneTimeTokenGenerationSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(OttSuccessHandler.class);

    /**
     * Default redirect handler to navigate the user after sending the token email.
     */
    private final OneTimeTokenGenerationSuccessHandler redirectHandler =
            new RedirectOneTimeTokenGenerationSuccessHandler("/ott/sent");
    /**
     * Service responsible for sending one-time token emails.
     */
    private final OneTimeTokenMailNotifier mailNotifier;

    public OttSuccessHandler(OneTimeTokenMailNotifier mailNotifier) {
        this.mailNotifier = mailNotifier;
    }

    private static final Map<String, String> USERS_EMAIL = Map.of(
            "omar", "omardrissi@gmail.com",
            "admin", "admin@example.com"
    );



    /**
     * Handles the logic after a one-time token has been successfully generated.
     * <p>
     * Steps performed:
     * <ol>
     *     <li>Retrieve the username and token value from the {@link OneTimeToken} object.</li>
     *     <li>Send an email to the user containing the token using {@link OneTimeTokenMailNotifier}.</li>
     *     <li>Log the result of the email sending process.</li>
     *     <li>Redirect the user to a confirmation page.</li>
     * </ol>
     *
     * @param request       the {@link HttpServletRequest} object
     * @param response      the {@link HttpServletResponse} object
     * @param oneTimeToken  the generated one-time token containing username and token value
     * @throws IOException      if an I/O error occurs during redirect
     * @throws ServletException if a servlet-specific error occurs
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, OneTimeToken oneTimeToken)
            throws IOException, ServletException {

        String username = oneTimeToken.getUsername();
        String tokenValue = oneTimeToken.getTokenValue();

        log.info("Generating one-time token for user: {}", username);

        try {
            mailNotifier.notify(getEmail(username), ONE_TIME_TOKEN.getSubject(), tokenValue);
            log.info("Sent one-time token email to {}", username);
        } catch (Exception e) {
            log.error("Failed to send one-time token email", e);
        }

        // Redirect user after sending the token
        this.redirectHandler.handle(request, response, oneTimeToken);
    }

    /**
     * Retrieves the email address for the given username.
     * <p>
     * Currently returns a placeholder email. Replace with real database lookup in production.
     *
     * @param username the username of the user
     * @return the email address associated with the username
     */

    private String getEmail(String username) {
        log.info("Retrieving email for user: {}", username);
        return USERS_EMAIL.getOrDefault(username, "default@example.com");
    }


}
