package com.bankofshanghai.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class GreetAspect {

	@Before("execution(* greetTo(..))")
	public void beforeGreeting() {
		System.out.println("How are you!");
	}

	@Around("PointcutName.greetTo()")
	public void pkgGreetTo(ProceedingJoinPoint pjp) throws Throwable {
		String name = (String) pjp.getArgs()[0];
		System.out.println("Hi " + name + "!");
		pjp.proceed();
		System.out.println("88 " + name + "!");
	}
}
