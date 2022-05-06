package com.worthen.cody.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AfterAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/**
	 * To only intercept after a method returns successfully:
	 * 
	 * Intercepts any return type, from PACKAGE, any class, all method calls,
	 * irrespective of their parameters:
	 * 
	 * Format: execution(* PACKAGE.*.*(..))
	 * 
	 * value is the pointcut which is used to intercept result is what we want to
	 * 
	 * return and it must match the argument name
	 */
	@AfterReturning(value = "execution(* com.worthen.cody.springaop.business.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		LOGGER.info("### {} returned with value {}", joinPoint, result);
	}

	/**
	 * To intercept when an exception is throw:
	 */
	@AfterThrowing(value = "execution(* com.worthen.cody.springaop.business.*.*(..))", throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception) {
		LOGGER.info("### {} throw exception {}", joinPoint, exception);
	}

	/**
	 * To intercept both successful returns AND exceptions:
	 */
	@After(value = "execution(* com.worthen.cody.springaop.business.*.*(..))")
	public void after(JoinPoint joinPoint) {
		LOGGER.info("### after execution of {}", joinPoint);
	}

}
