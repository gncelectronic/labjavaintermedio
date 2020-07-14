package org.frmutn.forkjoin;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

public class FiboAppParallel {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		System.out.println("Ingrese el valor de n: ");
		
		try (Scanner s = new Scanner(System.in)) {

			long n = s.nextLong();
			
			int coreCount = Runtime.getRuntime().availableProcessors();
		
			//Creo la tarea
			ForkJoinTask<Long> task = new Fibonacci(n);
			//Creo un pool de tipo ForkJoinPool para ejecutar la tarea
			ForkJoinPool pool = new ForkJoinPool(coreCount);		
			
			Instant timeStart = Instant.now();
			
			
			 Future<Long> resultado=  pool.submit(task);
			 
			//long rta = new ForkJoinPool().invoke(task);
			
			 /**
			  * Lo siguiente que hago es verificar si la tarea termino y si no muestro una barra de progreso
			  */
			 try {
			 System.out.write("\r|".getBytes());
			 	while(!resultado.isDone()) {
				
		            System.out.write("-".getBytes()  );
                    Thread.sleep(1000);
                    
		            
		     
			}
			 	System.out.write("| Listo \r\n".getBytes());
			 	
			 } catch (InterruptedException | IOException e) {
	                e.printStackTrace();
	            } 	
			 	
			Instant timeStop = Instant.now();
			double duracion = Duration.between(timeStart, timeStop).toMillis()/1000.0;
			
			System.out.println("Cantidad de core de CPU:" + coreCount);
			System.out.println("El valor de n es: " + resultado.get());
			System.out.println("Tiempo de procesamiento: "+duracion+" seg.");
			
			pool.shutdown();
		}

	}

}
