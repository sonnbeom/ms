package com.hypeboy.hypeBoard.config;

import com.hypeboy.hypeBoard.enums.EndPoint;
import com.hypeboy.hypeBoard.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity

public class SecurityConfig {
    private static final String SESSION_NAME = "JSESSIONID";
    private static final String USER_ID_KEY = "id";
    private static final String USER_PWD_KEY = "pwd";
    private static final String[] PROTECTED_ENDPOINTS = {
            EndPoint.Path.LOGIN_RESULT
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(PROTECTED_ENDPOINTS).authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .usernameParameter(USER_ID_KEY)
                        .passwordParameter(USER_PWD_KEY)
                        .loginPage(EndPoint.Path.LOGIN)
                        .loginProcessingUrl(EndPoint.Path.LOGIN_ACTION)
                        .defaultSuccessUrl(EndPoint.Path.LOGIN_RESULT)
                )
                .logout((logout) -> logout
                        .logoutUrl(EndPoint.Path.LOGOUT)
                        .logoutSuccessUrl(EndPoint.Path.LOGIN)
                        .deleteCookies(SESSION_NAME)
                )
                .build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}