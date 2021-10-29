package com.douzone.config.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfig {
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSoure = new ResourceBundleMessageSource();
		messageSoure.setBasename("com/douzone/mysite/config/web/message_ko");
		messageSoure.setDefaultEncoding("utf-8");
		return messageSoure;
	}
}
