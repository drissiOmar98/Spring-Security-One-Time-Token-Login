package dev.omar.spring_security_one_time_token_login.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static dev.omar.spring_security_one_time_token_login.common.EmailTemplates.ONE_TIME_TOKEN;


@Service
@Slf4j
public class OneTimeTokenMailNotifier {

    private final JavaMailSenderImpl mailSender;
    private final HttpServletRequest currentRequest;
    private final SpringTemplateEngine templateEngine;

    public OneTimeTokenMailNotifier(JavaMailSenderImpl mailSender, HttpServletRequest httpServletRequest, SpringTemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.currentRequest = httpServletRequest;
        this.templateEngine = templateEngine;
    }


    public void notify(String address, String title, String token) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        // Build link for the token
        var link = UriComponentsBuilder.fromUriString(UrlUtils.buildFullRequestUrl(currentRequest))
                .replacePath("/login/ott")
                .replaceQuery(null)
                .fragment(null)
                .queryParam("token", token)
                .toUriString();

        System.out.println("Magic Link: " +link);


        // Prepare variables for the template
        Map<String, Object> variables = Map.of(
                "token", token,
                "link", link
        );

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(
                    mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name()
            );

            messageHelper.setFrom("spring-security@example.com");
            messageHelper.setTo(address);
            messageHelper.setSubject(ONE_TIME_TOKEN.getSubject());

            Context context = new Context();
            context.setVariables(variables);

            // Use the template from the enum
            final String templateName = ONE_TIME_TOKEN.getTemplate();
            String htmlContent = templateEngine.process(templateName, context);

            messageHelper.setText(htmlContent, true);

            mailSender.send(mimeMessage);

            log.info("INFO - Email successfully sent to {} with template {}", address, templateName);

        } catch (MessagingException e) {
            log.error("WARNING - Cannot send Email to {}: {}", address, e.getMessage());
        }
    }

}
