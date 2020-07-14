package org.frmutn.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableApp {

	public static void main(String[] args) {

		ExecutorService exec = Executors.newFixedThreadPool(2);
		//trabaja como una promesa 
		Future<String> task1 = exec.submit(new HiloCallable<String>());
		Future<?> task2 = exec.submit(new HiloRunnable());
		/**
		 * tiempo muerto
		 */
		
		while(!task1.isDone() && !task2.isDone()) {}
		
		try {
			System.out.println(task1.get());
			System.out.println(task2.get());
			
			
			exec.shutdown();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
