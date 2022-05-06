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
	 * Format: execution(* PACKAGE.*.*(..))
	 * 
	 * However, this intercepts any calls inside of springaop package (2 dots):
	 * 
	 * @Before("execution(* com.worthen.cody.springaop..*.*(..))")
	 */
	// we could also use our CommonJoinPointConfig instead:
//	@Before("com.worthen.cody.springaop.aspect.CommonJoinPointConfig.dataLayerExecution()")
	@Before("execution(* com.worthen.cody.springaop.data.*.*(..))")
	public void before(JoinPoint joinPoint) { // JoinPoint gives us the tracing details

		// what we do during an intercept is called an "Advice"
		LOGGER.info("*** Check for user access:");
		LOGGER.info("*** Allowed execution for: {}", joinPoint);
	}

}
