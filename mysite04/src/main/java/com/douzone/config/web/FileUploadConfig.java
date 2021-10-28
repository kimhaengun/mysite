package com.douzone.config.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@PropertySource({"classpath:com/douzone/mysite/config/web/fileupload.properties"})
public class FileUploadConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver mutipatResolver = new CommonsMultipartResolver();
		mutipatResolver.setMaxUploadSize(env.getProperty("fileupload.maxUploadSize",Long.class));
		mutipatResolver.setMaxInMemorySize(env.getProperty("fileupload.maxInMemorySize",Integer.class));
		mutipatResolver.setDefaultEncoding(env.getProperty("fileupload.defaultEncoding"));
		return mutipatResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry
		.addResourceHandler(env.getProperty("fileupload.resourceMapping"))
		.addResourceLocations("file:"+env.getProperty("fileupload.uploadLocation"));
	}
	
	
}
