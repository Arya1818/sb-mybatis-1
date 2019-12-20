package com.bdi.sb.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LogAOP {
//	@Before("execution(* com.bdi.sb.controller..*())")
//	public void before(JoinPoint jp) {
//		log.info("나는 비포");
//		log.info("join point=>{}",jp);
//	}
//	@After("execution(* com.bdi.sb.controller..*())")
//	public void after(JoinPoint jp) {
//		log.info("나는 애프터, 난 메서드가 실행된 뒤 실행됨");
//		log.info("join point=>{}",jp);
//	}
//	
//	@Around("execution(* com.bdi.sb.controller..*())")
//	public Object around(ProceedingJoinPoint pjp) throws Throwable {
//		log.info("나는 어라운드");
//		log.info("ProceedingJoinPoint=>{}",pjp);
//		Object ojb = pjp.proceed();
//		return ojb;
//		
//	}
	@Before("execution(public String com.bdi.sb.controller..*())")
	public void before1(JoinPoint jp) {
		log.info("aop1=>{}",jp);
	}
	@Before("execution(private void com.bdi.sb.controller..*())")
	public void before2(JoinPoint jp) {
		log.info("aop2=>{}",jp);
	}
	@Before("execution(public java.util.List<String> com.bdi.sb.controller..*())")
	public void before3(JoinPoint jp) {
		log.info("aop3=>{}",jp);
	}
	@Before("execution(private java.util.List<String> com.bdi.sb.controller..*())")
	public void before4(JoinPoint jp) {
		log.info("aop4=>{}",jp);
	}
	
}

