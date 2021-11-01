package com.douzone.mysite.config;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.douzone.mysite.security.AuthInterceptor;
import com.douzone.mysite.security.AuthUserHandlerMethodArgumentResolver;
import com.douzone.mysite.security.LoginInterceptor;
import com.douzone.mysite.security.LogoutInterceptor;

@Configuration
@PropertySource({"classpath:com/douzone/mysite/config/WebConfig.properties"})
public class WebConfig implements WebMvcConfigurer {
	
	//FileUpload
	@Autowired
	private Environment env;
	
	/*
	 * Security 부분
	 */
	//Argument Resolver
	@Bean
	public HandlerMethodArgumentResolver handlerMethodArgumentResolver() {
		
		return new AuthUserHandlerMethodArgumentResolver();
	}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(handlerMethodArgumentResolver());
	}
	//Interceptors
	//로그인 인터셉터
	@Bean
	public HandlerInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	//로그아웃 인터셉서
	@Bean
	public HandlerInterceptor logoutInterceptor() {
		return new LogoutInterceptor();
	}
	
	//auth
	@Bean
	public HandlerInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(loginInterceptor()).addPathPatterns("/user/auth");
		registry.addInterceptor(logoutInterceptor()).addPathPatterns("/user/logout");
		registry.addInterceptor(authInterceptor()).addPathPatterns("/**")
												  .excludePathPatterns("/user/auth")
												  .excludePathPatterns("/user/logout")
												  .excludePathPatterns("/assets/**");
		
	}
	
	/*
	 * MvcConfig 부분
	 */
	//Message Converter
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter messageConverter = new StringHttpMessageConverter();
		
		messageConverter.setSupportedMediaTypes(
				Arrays.asList(
					new MediaType("text","html",Charset.forName("utf-8"))));
		return messageConverter;
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		Jackson2ObjectMapperBuilder builder = 
				new Jackson2ObjectMapperBuilder().indentOutput(true)
												 .dateFormat(new SimpleDateFormat("yyyy-mm-dd"));
		
		MappingJackson2HttpMessageConverter messageConverter = 
				new MappingJackson2HttpMessageConverter(builder.build());
		messageConverter.setSupportedMediaTypes(
				Arrays.asList(
					new MediaType("application","json",Charset.forName("utf-8"))));		
		
		return messageConverter;
	}
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(stringHttpMessageConverter());
		converters.add(mappingJackson2HttpMessageConverter());
	}
	
	/*
	 * FileUploadConfig 부분
	 */
	// (ResourceMapping (URL Magic Mapping))
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry
		.addResourceHandler(env.getProperty("fileupload.resourceMapping"))
		.addResourceLocations("file:"+env.getProperty("fileupload.uploadLocation"));
	}
}
