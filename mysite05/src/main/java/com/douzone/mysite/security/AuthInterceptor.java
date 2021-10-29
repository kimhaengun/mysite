package com.douzone.mysite.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.douzone.mysite.vo.UserVo;


public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		//1.hangler 종류 확인하기
		if(handler instanceof HandlerMethod == false) {
			return true;
		}
		
		//2. 컨트롤러 Handler면
		//   casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		// ======================================================
		//3. 본격 작업
		//   Handler Method의 @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		//4. 만약 Handler Method에 @Auth가 없으면
		//   TYPE(Class)에 있는지 확인
		if(auth == null) {
			//과제
			auth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
		}
		
		//5. Type(class)과 method에 @Auth가 적용 안되어 있는 경우는
		if(auth ==null) {
			// 인증이 필요없음
			return true;
		}
		
		//6. type or method에 @Auth가 있다면
		//   -->인증(Authenfication) 여부 확인해야한다.
		HttpSession session = request.getSession();
		if(session==null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;			
		}
		
		//현재 세션 UserVo 주입
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		if(authUser == null) {
			response.sendRedirect(request.getContextPath()+"/user/login");
			return false;
		}
		
		//7.권한(Authorization) 체크를 위해서 @Auth의 role 가져오기("USER","ADMIN")
		String role = auth.role();
		
		//8.권한 체크 (과제)
		// user는 admin페이지 접근 불가능 / admin은 user,admin페이지 모두 접근 가능
		
		//현재 유저의 권한 체크
		String userRole = authUser.getRole();
		
		if("ADMIN".equals(userRole) == false) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		if(role.equals("USER") ) {
			return true;
		}
		return true;
	}

	
}
