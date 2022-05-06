package com.worthen.cody.springaop.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // We only want to use this annotation on methods, not classes
@Retention(RetentionPolicy.RUNTIME) // make it available at runtime
public @interface TrackTime {

}
