package org.frmutn.ejecutors;

public class Hilo3 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<1000000 ; i++) {
			System.out.print("x");
		}
		
		System.out.println();

	}

}
