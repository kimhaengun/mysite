package com.douzone.mysite.exception;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.douzone.mysite.dto.JsonResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Log LOGGER = LogFactory.getLog(GlobalExceptionHandler.class);
	
	//받아야할 클래스(Exception이 발생하는 모든 class)
	@ExceptionHandler(Exception.class)
	public void HandlerException(
			HttpServletRequest request, HttpServletResponse response,
			Exception e) throws Exception{
		//1.로깅 - 파일로 남겨야함.
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors)); //어떤 곳에서 발생했는지 알려줌
		LOGGER.error(errors.toString());
		
		//2. 요청 구분 (jsp인지 json 인지)
		//만약 Json 요청일 경우, request header의 accept에 application/json
		//만약 html 요청일 경우, request header의 accept에 text/html
		
		String accept = request.getHeader("accept");
		 //모든 문자열 ~application/json~의 문자열
		if(accept.matches(".*application/json.*")) {
			//3.JSON 응답
			JsonResult result = JsonResult.fail(errors.toString());
			//JSON 생성
			String jsonString = new ObjectMapper().writeValueAsString(result);
			// SC_OK = 200
			response.setStatus(HttpServletResponse.SC_OK);
			OutputStream os = response.getOutputStream();
			os.write(jsonString.getBytes("utf-8"));
			os.close();
		}else {
			//4. 사과 페이지 미안해 - 정상 종료까지
			//내가 만든 코드가 이상해..
			request.setAttribute("exception", errors.toString());
			request.getRequestDispatcher("/WEB-INF/views/error/exception.jsp")
					.forward(request, response);
					
		}
		

	}
}
