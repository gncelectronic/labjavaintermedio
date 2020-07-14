package org.frmutn.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkServerMain {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Runnable> runners = new ArrayList<>();
		
		for(int port = 10000 ; port <10010;port++) {
			Runnable r;
			try {
			     r= new PriceRangeServer(port,20, 110);
			     runners.add(r);
			}catch(IOException e) {
				System.out.println("Puerto " + port + " ya en uso..");
			}
		}
		for(Runnable r: runners) {
			exec.execute(r);
		}
		

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        System.out.println("Presione enter para salir...");
        try {
            System.in.read();
        } catch (IOException ex) {
        }
        System.out.println("Saliendo...");
        exec.shutdown();
		

	}

}
