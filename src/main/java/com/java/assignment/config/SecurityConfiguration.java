package com.java.assignment.config;

import com.java.assignment.constants.AppConstants;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

/**
 * Security Configuration class
 *
 * @author Jithin KM
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    /**
     * Bean for {@link UserDetailsService}.
     * The method is to create bean for user details service
     */
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles(AppConstants.ROLE_USER)
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles(AppConstants.ROLE_USER, AppConstants.ROLE_ADMIN)
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    /**
     * Bean for {@link ServletListenerRegistrationBean}.
     * The method is to create bean for session event publisher
     */
    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
    }

    /**
     * Bean for {@link SecurityFilterChain}.
     * The method is to create security filter chain
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers(RegexRequestMatcher.regexMatcher("\\/account\\/[0-9]+[?][a-zA-Z]+[=].*"))
                        .hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin((login) -> login.permitAll())
                .logout((logout) -> logout.permitAll())
                .sessionManagement(session ->
                        session.maximumSessions(1).maxSessionsPreventsLogin(true)
                );

        return http.build();
    }
}
