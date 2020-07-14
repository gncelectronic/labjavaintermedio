package org.frmutn.ejecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjecutorTest {
	
	public static void main(String [] args) {
		Thread t1 = new Thread(new Hilo1());
		Thread t2 = new Thread(new Hilo2());
		Thread t3 = new Thread(new Hilo3());
		
		
		/**
		 * Sin ejecutor deberiamos lanzar los hilos de la siguiente forma
		 * 
		 */
		
//		t1.start();
//		t2.start();
//		t3.start();
		
		/**
		 * Usando Ejecutor podemos gestionar los hilos de la siguiente forma
		 */
		
//		ExecutorService exec = Executors.newCachedThreadPool();
		/**
		 * Con un solo hilo se ejecutan todas las tareas
		 */
//		ExecutorService exec = Executors.newSingleThreadExecutor();
		
		/**
		 * Especificamos la cantidad de hilos que tendra mi Pool
		 */
		
//		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		
		/**
		 * Planificar tareas
		 */
		
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
		//planificar la tarea que se ejecute cada 5 segundos
		exec.scheduleAtFixedRate(t1, 0,5, TimeUnit.SECONDS);
		
		
//		exec.execute(t1);
//		exec.execute(t2);
//		exec.execute(t3);
		
		/**
		 * para parar los hilos
		 */
		//exec.shutdown();
	}

}
