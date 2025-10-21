package dev.omar.spring_security_one_time_token_login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/ott/sent").permitAll()
                        .requestMatchers("/login/ott").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .oneTimeTokenLogin(Customizer.withDefaults())
                .build();
    }


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        var omar = User.withUsername("omar")
                .password("{noop}password")
                .build();

        var admin = User.withUsername("admin")
                .password("{noop}admin123")
                .build();

        return new InMemoryUserDetailsManager(omar, admin);
    }




}
