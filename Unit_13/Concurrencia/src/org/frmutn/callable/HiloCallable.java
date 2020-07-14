package org.frmutn.callable;

import java.util.concurrent.Callable;

public class HiloCallable<V> implements Callable<String> {

	@Override
	public String call() throws Exception {
		
		return "Hilo callable";
	}

}
