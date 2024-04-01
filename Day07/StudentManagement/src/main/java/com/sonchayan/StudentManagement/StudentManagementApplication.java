package com.sonchayan.StudentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}
//to find which language
	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver locale=new SessionLocaleResolver();
		locale.setDefaultLocale(Locale.ENGLISH);
		return locale;
	}
//this is for search files
	@Bean
	public ResourceBundleMessageSource resourceBundleMessageSource(){
		ResourceBundleMessageSource message=new ResourceBundleMessageSource();
		message.setBasename("reply");
		return message;
	}

}
