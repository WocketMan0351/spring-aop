package com.worthen.cody.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * We can use AOP to intercept method(s) before they are called. Modularizing
 * our code like this can help avoid useless clutter throughout our classes with
 * crosscutting concerns.
 */

// this class declares one or more @Bean methods and may be processed by the Spring container 
@Configuration
// this is an aspect
@Aspect
public class BeforeAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/**
	 * this method needs to be called before the execution of another method we pass
	 * in a "pointcutter"
	 * 
	 * Intercepts any return type, from PACKAGE, any class, all method calls,
	 * irrespective of their parameters:
	 * 
	 * format: execution(* PACKAGE.*.*(..))
	 */
	@Before("execution(* com.worthen.cody.springaop.business.*.*(..))")
	public void before(JoinPoint joinPoint) { // JoinPoint gives us the details
		LOGGER.info("Intercepted Method Calls: {}", joinPoint);
	}

}