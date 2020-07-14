package org.frmutn.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Incrementar una variable entera por diferentes hilos sin usar bloqueo pesimista.
 * El codigo comienza con 5 hilos que cada uno incremenrta la variable atomicInteger, el hilo con suerte que obtenga como respuiesta 42 imprime el valor por la consola
 * @author Gaston
 *
 */
public class AtomicIntegerExample implements Runnable {
	private static final AtomicInteger atomicInteger = new AtomicInteger();
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0; i<5; i++) {
			exec.execute(new AtomicIntegerExample());
			
			
		}
		exec.shutdown();
	}

	@Override
	public void run() {
	for(int i=0; i<10;i++) {
		int valorNuevo = atomicInteger.getAndIncrement();
		
		if(valorNuevo == 42) {
			System.out.println("["+Thread.currentThread().getName()+"]: "+ valorNuevo);
		}
	}

	}

}
