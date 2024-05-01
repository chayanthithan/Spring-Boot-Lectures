package com.sonchayan.UserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	//2 beans
	//1.localeResolver
	//2.ResourceBundleMessageSource

	//to find which language
	@Bean
	public LocaleResolver localeResolver(){

		SessionLocaleResolver locale = new SessionLocaleResolver();//session //request /login, /register

		locale.setDefaultLocale(Locale.ENGLISH);

		return locale;
	}


	//to search file (.properties)
	@Bean
	public ResourceBundleMessageSource resourceBundleMessageSource (){
		ResourceBundleMessageSource message = new ResourceBundleMessageSource();
		message.setBasename("messages");// messages.prp, messgaes_ta.prop
		return message;
	}




}
