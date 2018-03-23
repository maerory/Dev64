package net.n1books.dev.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopAdviceController {
	private static final Logger logger = 
			LoggerFactory.getLogger(AopAdviceController.class);
	
	@Before("execution(* net.n1books.dev.article.controllers.ArticleController.insert(..))")
	public void ad_before(JoinPoint joinPoint) {
		logger.info("♡♡♡♡♡♡♡♡♡♡♡♡");
		logger.info("♡    before advice   ♡");
		logger.info("♡♡♡♡♡♡♡♡♡♡♡♡");
		Object[] args = joinPoint.getArgs();
		
		for(Object obj: args) {
			logger.info("obj : " + obj);
		}
	}
	
	@After("execution(* net.n1books.dev.article.controllers.ArticleController.insert(..))")
	public void ad_after() {
		logger.info("♡♡♡♡♡♡♡♡♡♡♡♡");
		logger.info("♡    after advice    ♡");
		logger.info("♡♡♡♡♡♡♡♡♡♡♡♡");
	}
	
	@Around("execution(* net.n1books.dev.article.controllers.ArticleController.insert(..))")
	public Object ad_around(ProceedingJoinPoint joinPoint) {
		logger.info("♡♡♡♡♡♡♡♡♡♡♡♡");
		logger.info("♡    around start    ♡");
		logger.info("♡♡♡♡♡♡♡♡♡♡♡♡");
		Object obj = null;
		
		try {
			logger.info("시간 측정을 시작합니다.");
			long start = System.currentTimeMillis();
			obj = joinPoint.proceed();
			long end = System.currentTimeMillis();
			
			logger.info("시간 측정을 종료합니다.");
			logger.info("수행 시간 : " + ((end - start)/1000.0 + "초"));
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		logger.info("♡♡♡♡♡♡♡♡♡♡♡♡");
		logger.info("♡    around end      ♡");
		logger.info("♡♡♡♡♡♡♡♡♡♡♡♡");
		return obj;
	}
}
