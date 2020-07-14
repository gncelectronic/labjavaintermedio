package org.frmutn.callable.fibo;

import java.util.concurrent.Callable;

public class Fibonacci implements Callable<Long> {
	private long n;
	
	

	public Fibonacci(long n) {
		super();
		this.n = n;
	}


	@Override
	public Long call() throws Exception {
	return getFibo(n);
	}

	/**
	 * Calculo del numero de Fibonacci
	 * @param n
	 * @return
	 */
	private long getFibo(long n) {
		if(n==0 || n ==1) {
			return n;
		}else {
			return getFibo(n-1) + getFibo(n-2);
		}
	}
}
