package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // TODO Disabling any spring Authentication for testing purpose. This class has to be removed!!
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/customers/**").permitAll() // Allow access to /customers
                        .anyRequest().permitAll() // Permit all other requests
                );
        return http.build();
    }
}
