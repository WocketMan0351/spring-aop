package com.worthen.cody.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class MetricsAspect {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/**
	 * Format: execution(* PACKAGE.*.*(..))
	 * 
	 * Use our CommonJoinPointConfig for re-usability/brevity
	 * 
	 * only track execution time of methods that have our own custom @TrackTime
	 * annotation
	 */
	@Around("com.worthen.cody.springaop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {

		// find the method execution time here rather than all over your code
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		LOGGER.info("Time Taken by {} is {}ms", joinPoint, timeTaken);
	}

}
