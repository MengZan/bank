package com.bankofshanghai.test;

public class Waiter {

	public void greetTo(String client) {
		System.out.println("Waiter is greeting to " + client + ".");
	}

	public void serveTo(String client) {
		System.out.println("Waiter is serving to " + client + ".");
	}

	public int getTips(int n) {
		return n * 10;
	}
}
