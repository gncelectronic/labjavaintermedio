package org.utnfrm.lab.uno;

public class PurchasingAgent {

	public PurchasingAgent() {
		super();
		
	}
	
	
	public void purchase() {
		Thread t =  Thread.currentThread();
		System.out.println("Hilo: "+ t.getName()+ ", "+t.getId());
		Store store = Store.getInstance();
		synchronized (store) {
			
			if(store.getShirtCount() >0 && store.authorizedCreditCard("12313", 522)) {
				Shirt shirt = store.takeShirt();
				System.out.println("Camisa comprada");
				System.out.println(shirt);
			}else {
				System.out.println("No puede realizarse la compra.");
			}
			
		}
		
	}
	
	

}
