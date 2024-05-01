package com.example.HospitalService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
//@EnableWebMvc   //when i create a bean this line got error
public class HospitalServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(HospitalServiceApplication.class, args);
	}
	//internationalization
	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver locale=new SessionLocaleResolver();
		locale.setDefaultLocale(Locale.ENGLISH);
		return locale;
	}

	@Bean
	public ResourceBundleMessageSource resourceBuldleMessageSource(){
		ResourceBundleMessageSource msg=new ResourceBundleMessageSource();
		msg.setBasename("message");
		return msg;
	}

}
