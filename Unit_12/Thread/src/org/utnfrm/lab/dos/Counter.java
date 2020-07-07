package org.utnfrm.lab.dos;

public class Counter implements Runnable {

	@Override
	public void run() {
		int x =0;
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("El valor actual de x es: "+ x++);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				return;
			}
		}
		
	}

	
}
