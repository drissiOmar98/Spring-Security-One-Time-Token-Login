package dev.omar.spring_security_one_time_token_login.common;

import lombok.Getter;

/**
 * Enum representing email templates used in the application.
 * Each template has a corresponding HTML file and an email subject.
 */
public enum EmailTemplates {

    ONE_TIME_TOKEN("one_time_token_email.html", "Your One-Time Login Token");

    @Getter
    private final String template;
    @Getter
    private final String subject;

    EmailTemplates(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
