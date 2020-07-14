package org.frmutn.cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NetworkClientMain {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Map<RequestResponse, Future<RequestResponse>> callables = new HashMap<>();
		
		String host="localhost";
		
		for(int port=10000; port<10010;port++) {
			RequestResponse lookup = new RequestResponse(host, port);
			NetworkClientCallable callable = new NetworkClientCallable(lookup);
			Future<RequestResponse> future = exec.submit(callable);
			callables.put(lookup, future);
			
			
			
		}
		
		exec.shutdown();
		
		 try {
	            //Block until all Callables have a chance to finish
			 exec.awaitTermination(5, TimeUnit.SECONDS);
	        } catch (InterruptedException ex) {
	            System.out.println("Stopped waiting early");
	        }

	        for (RequestResponse lookup : callables.keySet()) {
	            Future<RequestResponse> future = callables.get(lookup);
	            try {
	                lookup = future.get();
	                System.out.println(lookup.getHost()+ ":" + lookup.getPort() + " " + lookup.getResponse());
	            } catch (ExecutionException | InterruptedException ex) {
	                //This is why the callables Map exists
	                //future.get() fails if the task failed
	                System.out.println("Error talking to " + lookup.getHost() + ":" + lookup.getPort());
	            }
	        }

	}

}
