package com.example.HospitalService.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityImplement(HttpSecurity security) throws Exception{
        //This line disables CSRF (Cross-Site Request Forgery) protection
        security.csrf().disable()
                .authorizeRequests()
                .requestMatchers("/register").permitAll()
                //This method begins configuring authorization rules for requests
//        This line specifies that any request to the application's endpoints must be authenticated
                .anyRequest().authenticated()
                //This configures HTTP Basic authentication
                .and().httpBasic();
        return security.build();
    }
}
