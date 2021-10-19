package com.douzone.mysite.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//받아야할 클래스(Exception이 발생하는 모든 class)
	@ExceptionHandler(Exception.class)
	public void HandlerException(
			HttpServletRequest request, HttpServletResponse response,
			Exception e) throws Exception{
		//1.로깅 - 파일로 남겨야함.
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors)); //어떤 곳에서 발생했는지 알려줌
		
		//2. 요청 구분 (jsp인지 json 인지)
		
		//3. 사과 페이지 미안해 - 정상 종료까지
		//내가 만든 코드가 이상해..
		request.setAttribute("exception", errors.toString());
		request.getRequestDispatcher("/WEB-INF/views/error/exception.jsp")
				.forward(request, response);
	
	}
}
