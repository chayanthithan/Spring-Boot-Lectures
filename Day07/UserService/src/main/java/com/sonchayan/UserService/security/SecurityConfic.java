package com.sonchayan.UserService.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfic {
    //i could access through postman without add this method by add dependency and username nd password in properties
    @Bean
    public SecurityFilterChain securityFeature(HttpSecurity http) throws Exception{
        http.csrf().disable()                   //this step refer disable csrf(cross site request forgery) feature to access by any request
                .authorizeRequests()
                .anyRequest().authenticated()   //this code for check username and password
                .and().httpBasic();             //httpBasic()  this is basic authorization
        return http.build();

    }
}
