package com.worthen.cody.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	// all calls within data packageß
	@Pointcut("execution(* com.worthen.cody.springaop.data.*.*(..))")
	public void dataLayerExecution() {

	}

	// all calls within business package
	@Pointcut("execution(* com.worthen.cody.springaop.business.*.*(..))")
	public void businessLayerExecution() {

	}

	// combine pointcuts
	@Pointcut("com.worthen.cody.springaop.aspect.CommonJoinPointConfig.dataLayerExecution() && com.worthen.cody.springaop.aspect.CommonJoinPointConfig.businessLayerExecution()")
	public void allLayerExecution() {

	}

	// any bean that contains "dao"
	@Pointcut("bean(*dao*)")
	public void beanContainingDao() {

	}

	// all calls within data package
	@Pointcut("within(com.worthe.cody.springaop.data..*)")
	public void dataLayerExecutionWithin() {

	}

	// how we can easily use our own annotation
	@Pointcut("@annotation(com.worthen.cody.springaop.aspect.TrackTime)")
	public void trackTimeAnnotation() {

	}

}
