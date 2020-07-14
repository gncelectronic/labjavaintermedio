package org.frmutn.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Clase que representa un contador con seguridad de hilos o thread Safe haciendo uso de Synchronized
 * @author Gaston
 *
 */
public class SynchronizedCounter implements Runnable {
	
	private static int c=0;
	
	public static void main(String [] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i = 0 ; i<5 ;i++) {
			exec.execute(new SynchronizedCounter() );
		}
		System.out.println("["+ Thread.currentThread().getName()+"]: El valor del contador es: " +c);
		exec.shutdown();
	}
	
	public synchronized void increment () {
		c++;
	}
	
	public synchronized void decrement() {
		c--;
	}
	
	
	public synchronized int value() {
		return c;
	}

	@Override
	public void run() {
		increment();
		
	}
	

}
