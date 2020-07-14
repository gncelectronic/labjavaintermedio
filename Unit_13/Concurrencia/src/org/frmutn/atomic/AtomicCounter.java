package org.frmutn.atomic;
/**
 * Clase que representa un contador con seguridad de hilo usando  una variable Atomic
 * @author Gaston
 *
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter  implements Runnable{
	
	private static AtomicInteger c = new AtomicInteger(0);
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0; i<5;i++) {
			exec.execute(new AtomicCounter());
			
		}
		System.out.println("["+Thread.currentThread().getName()+"]: El valor de contador es:" +c.get());
		exec.shutdown();
	}
	
	
	public void increment() {
		c.incrementAndGet();
	}
	
	
	public void decrement() {
		c.decrementAndGet();
	}
	
	public int value() {
		return c.get();
	}


	@Override
	public void run() {
	//	System.out.println("["+Thread.currentThread().getName()+"]:"+c.get());
		increment();
		
		
	}
		

}
