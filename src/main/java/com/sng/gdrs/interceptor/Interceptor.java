package com.sng.gdrs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class Interceptor extends HandlerInterceptorAdapter {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("인터셉터 시작");

		return super.preHandle(request, response, handler);
	}
	
	//컨트롤러 실행 후 수행 로직
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("인터셉터 종료");
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	// View 랜더링이 끝난 직후 수행
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("View 랜더링이 끝난 직후 인터섹터 종료");
		super.afterCompletion(request, response, handler, ex);
	}
	
	//비동기식 호출 수행
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
}
