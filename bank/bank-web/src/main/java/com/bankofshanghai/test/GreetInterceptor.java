package com.bankofshanghai.test;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		String client = (String) args[0];
		System.out.println("How are you! Dear " + client + ".");
		Object obj = invocation.proceed();
		System.out.println("88");
		return obj;
	}

}
