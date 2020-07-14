package org.frmutn.forkjoin;

import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final long n;

	public Fibonacci(long n) {
		super();
		this.n = n;
	}

	@Override
	protected Long compute() {
		if(n <= 1) {
			return n;
		}
		
		Fibonacci f1 = new  Fibonacci(n-1);
		f1.fork();
		Fibonacci f2 = new Fibonacci(n-2);
		f2.fork();
		return f2.join() + f1.join();
	}
	

}
