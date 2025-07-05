//package com.library.aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//
//@Aspect
//public class LoggingAspect {
//
//    @Around("execution(* com.library.service.*.*(..))")
//    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//
//        Object proceed = joinPoint.proceed();
//
//        long executionTime = System.currentTimeMillis() - start;
//
//        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
//        return proceed;
//    }
//}


//Exercise 8
package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("BEFORE " + joinPoint.getSignature().getName() + " is about to be called");
    }

    @After("execution(* com.library.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("AFTER " + joinPoint.getSignature().getName() + " has completed execution");
    }
}
