package org.utnfrm.lab.uno;

import java.util.Deque;
import java.util.LinkedList;

public class Store {
	private Deque<Shirt> shirts = new LinkedList<>();
	/**
	 * Patron Singleton
	 */
	private static Store instance = new Store();
	
	private Store() {
		
	}
	
	public static Store getInstance() {
		return instance;
	}
	
	
	public  void addShrit(Shirt shirt) {
		System.out.println("Agregando camisas al carrito.");
		shirts.push(shirt);
		System.out.println("Total de camisas: "+ shirts.size());
	}
	
	public Shirt takeShirt() {
		return shirts.pop();
	}
	
	
	public int getShirtCount() {
		return shirts.size();
	}
	
	
	public boolean authorizedCreditCard(String accountNumber, double mount) {
		
		int seconds = (int) (Math.random() *3+1);
		System.out.println("Durmiendo por"+ seconds +"segundos");
		try {
			Thread.sleep(seconds*1000);
		}catch(InterruptedException e) {
			System.out.println("Interrumpido");
		}
		
		
		return true;
		
	}

}
