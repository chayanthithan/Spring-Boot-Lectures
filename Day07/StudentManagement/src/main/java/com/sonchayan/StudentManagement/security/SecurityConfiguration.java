package com.sonchayan.StudentManagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity hs) throws Exception {
        hs.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/register").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
        return hs.build();
    }

}
