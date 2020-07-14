package org.frmutn.callable.fibo;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class FiboAppRunnable {
	
	public static void main(String [] args) {
		
		FibonnaciRunnable r = new FibonnaciRunnable(45);
		
		
        Thread t = new Thread(r,"Hilo-Fibo");
        Instant timeStart = Instant.now();
        t.start();
       
        while(t.isAlive()) {
        	
        	for(int i =0; i<100;i++) {
        
        		
        		System.out.print("Calculando: " + i+ "% \r" );
        		
			
        		try {
        			Thread.sleep(100);
        		}catch(InterruptedException e) {
        			
        		}
        	}
        	System.out.flush();  
        	
        }
        Instant timeEnd = Instant.now();
        double duracion = Duration.between(timeStart, timeEnd).getSeconds();
       
        System.out.println("Resultado: "+r.getResultado());
        System.out.println("Tiempo procesamiento: "+ duracion +" seg." );
		
	}

}
