package com.bankofshanghai.test;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutName {

	@Pointcut("within(com.bankofshanghai.*)")
	private void inPackage() {
	}

	@Pointcut("execution(* greetTo(..))")
	protected void greetTo() {
	}

	// ?用不了
	@Pointcut("inPackage() and greetTo()")
	public void inPkgGreetTo() {
	}
}
