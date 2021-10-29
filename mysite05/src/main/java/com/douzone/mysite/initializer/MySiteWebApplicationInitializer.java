package com.douzone.mysite.initializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.douzone.mysite.config.AppConfig;
import com.douzone.mysite.config.WebConfig;

public class MySiteWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {AppConfig.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	//Filter
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return new Filter[] {new CharacterEncodingFilter("UTF-8",false)};
	}

	//에러 발생 시
	//톰켓 default handler -> defualt servlret
	@Override
	protected void customizeRegistration(Dynamic registration) {
		//해당 handler 가 없으면 
		//spring에게 throwExceptionInfNoHanlderFound 요청을 함.
		registration.setInitParameter("throwExceptionInfNoHandlerFound", "true");
	}
	
	
}
