package com.douzone.mysite.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//method에 붙일 때는 METHOD
//class에 붙일 때는 TYPE
@Target({ElementType.METHOD,ElementType.TYPE})
//시작 시 실행 = RUNTIME
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
//	public String value() default "USER";
	public String role() default "USER";
//	public boolean test() default false;
}
