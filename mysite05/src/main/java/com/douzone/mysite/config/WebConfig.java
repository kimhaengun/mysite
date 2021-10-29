package com.douzone.mysite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.douzone.config.web.FileUploadConfig;
import com.douzone.config.web.MessageConfig;
import com.douzone.config.web.MvcConfig;
import com.douzone.config.web.SecurityConfig;
import com.douzone.mysite.security.LoginInterceptor;
import com.douzone.mysite.security.SiteInterceptor;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.douzone.mysite.controller","com.douzone.mysite.exception"})
@Import({MvcConfig.class, MessageConfig.class,FileUploadConfig.class,SecurityConfig.class})
public class WebConfig {
	
//	//siteInterceptors
//	@Bean
//	public HandlerInterceptor siteInterceptor() {
//		return new SiteInterceptor();
//	}
//	
//	public void addInterceptors(InterceptorRegistry registry) {
//		// TODO Auto-generated method stub
//		registry.addInterceptor(siteInterceptor()).addPathPatterns("/**");
//		
//	}
}
