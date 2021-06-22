package com.sng.gdrs.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerDaoAOP {
	
	public void before(JoinPoint j) {
		Logger log = LoggerFactory.getLogger(j.getTarget()+"");
		log.warn("메소드 실행전");
		
		Object[] objs = j.getArgs();
		if(objs!=null) {
			log.warn(" {} ", j.getSignature().getName());
			for (int i = 0; i < objs.length; i++) {
				log.warn(i+"번째 Args :\t "+String.valueOf(objs[i]));
			}
			
			log.warn(" {} ", j.getSignature().getName());
		}
	}

	public void afterReturning(JoinPoint j) {
		Logger log = LoggerFactory.getLogger(j.getTarget()+"");
		log.warn(" 종료 : \t {} ", j.getSignature().getName());
		
	}

	public void afterThrowing(JoinPoint j, Exception exception) {
		Logger log = LoggerFactory.getLogger(j.getTarget()+"");
		log.warn("에러발생 : \t {} ", j.getSignature().getName());
		log.warn(" 에러발생 : \t {} ", exception.getMessage());
		
	}

}
