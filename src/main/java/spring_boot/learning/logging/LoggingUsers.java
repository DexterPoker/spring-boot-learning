package spring_boot.learning.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
* @author DexterPoker
* @date 2017年1月20日-下午1:42:30
**/
@Aspect
@Component
public class LoggingUsers {

	private final static Logger logger = LoggerFactory.getLogger(LoggingUsers.class);
	
	@Pointcut("execution(public * spring_boot.learning.controller.UsersController.*(..))")
	public void UsersLog(){}
	
	@Before(value = "UsersLog()")
	public void BeforeMethod(JoinPoint joinPoint){
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		logger.info("the method " + method + " begins with : " + Arrays.asList(args));
	}
	
	@After(value = "UsersLog()")
	public void afterMethod(JoinPoint joinPoint){
		String method = joinPoint.getSignature().getName();
		logger.info("the method " + method + " ends.");
	}
	
	@AfterReturning(value = "UsersLog()",returning = "result")
	public void afterReturnMethod(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		logger.info("the method " + methodName + " return : " + result  );
	}
	
	@AfterThrowing(value = "UsersLog()",throwing = "ex")
	public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
		String methodName = joinPoint.getSignature().getName();
		logger.info("the method " + methodName + " occurs excetion : " + ex  );
	}
	
}
