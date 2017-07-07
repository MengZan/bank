package com.bankofshanghai.test;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class GreetBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object obj) throws Throwable {
		System.out.println(obj.getClass().getName() + "." + method.getName());
		String client = (String) args[0];
		System.out.println("How are you! Dear " + client + ".");
	}

}
