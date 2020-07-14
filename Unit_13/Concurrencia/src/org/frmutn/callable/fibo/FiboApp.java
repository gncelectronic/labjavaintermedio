package org.frmutn.callable.fibo;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FiboApp {
	
	public static void main(String [] args) throws InterruptedException, ExecutionException{
		
		char[] animationChars = new char[]{'|', '/', '-', '\\'};
		
		System.out.println("Ingrese valor a calcular:");
		if(args.length<1) {
			System.out.println("Debe ingresar un  valor entero para calcular.");
			System.exit(0);
		}
		
		try (Scanner s = new Scanner(System.in)) {
			long n = s.nextLong();
			int coreCount = Runtime.getRuntime().availableProcessors();
			ExecutorService exec = Executors.newFixedThreadPool(coreCount);
			Instant timeStart = Instant.now();
			Future<Long> valor = exec.submit(new Fibonacci(n));
			
			 try {
				 System.out.write("\r|".getBytes());
				 	while(!valor.isDone()) {
					
			            System.out.write("*".getBytes()  );
	                    Thread.sleep(1000);
	                    
			            
			     
				}
				 	System.out.write("| Listo \r\n".getBytes());
				 	
				 } catch (InterruptedException | IOException e) {
		                e.printStackTrace();
		            } 
			Instant timeEnd = Instant.now();
			System.out.println("Valor calculado de "+ n +", es: " + valor.get().toString() );
			double duration =Duration.between(timeStart, timeEnd).getSeconds();
			System.out.println("Tiempo de procesamiento: "+ duration + " seg.");
			
			exec.shutdown();
		}
	}

}
