package com.example.aopdemo.annotation;

// market annotation
// Configured annotation

import java.lang.annotation.*;

@Target(ElementType.METHOD)  // Restrict the method only where it can use
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {
    long warnAfter() default 2000;

    String operation() default "";
}
