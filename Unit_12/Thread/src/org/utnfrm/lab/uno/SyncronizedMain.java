package org.utnfrm.lab.uno;

public class SyncronizedMain {

	public static void main(String[] args) {
	Store store = Store.getInstance();
	store.addShrit(new Shirt("100","Polo","Rojo","Large"));

	PracticeThread t1 = new PracticeThread();
	PracticeThread t2 = new PracticeThread();
	
	t1.start();
	t2.start();
	
	
	}

}
