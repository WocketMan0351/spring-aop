package com.worthen.cody.springaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("execution(* com.worthen.cody.springaop.data.*.*(..))")
	public void dataLayerExecution() {

	}

	@Pointcut("execution(* com.worthen.cody.springaop.business.*.*(..))")
	public void businessLayerExecution() {

	}

}
