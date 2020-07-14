package org.frmutn.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Clase  representa un contador que no es  Thread Safe o hilo seguro.
 * @author Gaston
 *
 */
public class Counter implements Runnable {

	private static  int c =0;
	
	public static void main(String [] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i =0; i<5 ; i++) {
			exec.execute(new Counter());
		}
		
		System.out.println("["+ Thread.currentThread().getName()+"]: el valor del counter es: "+ c);
		exec.shutdown();
	}
	
	public void increment() {
		c++;
	}
	
	public void decrement() {
		c--;
	}
	
	public int value() {
		return c;
	}

	@Override
	public void run() {
		increment();
		
	}
	
	
	
}
