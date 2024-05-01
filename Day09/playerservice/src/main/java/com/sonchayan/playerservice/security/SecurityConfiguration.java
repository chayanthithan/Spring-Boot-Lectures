package com.sonchayan.playerservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecure) throws Exception{
        httpSecure.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
        return httpSecure.build();
    }
}
