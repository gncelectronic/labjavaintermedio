package org.utnfrm.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart implements Serializable {
	
	private static final long serialVersionUID = 6L;
	private int cartId;
	private List<Item> items;
	private int itemCount;
	private transient double cartTotal;
	public ShoppingCart(int cartId) {
		super();
		this.cartId = cartId;
		this.items = new ArrayList<>();
		this.itemCount = 0;
		this.cartTotal = 0;
	}
	
	public void addItem(Item item) {
		if(items.add(item)) {
			cartTotal +=item.getPrecio();
		}
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getCartId() {
		return cartId;
	}
	public List<Item> getItems() {
		return items;
	}
	
	public int getCartSize() {
		return items.size();
	}
	
	public double getCartTotal() {
		return cartTotal;
	}
	
	/**
	 * Metodo llamado durante la deserializacion
	 * @param ois
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream ois)throws IOException, ClassNotFoundException{
		ois.defaultReadObject();
		
		if(cartTotal == 0 && (items.size()>0)) {
			for(Item item: items) {
				cartTotal+=item.getPrecio();
			}
		}
		
		Date date = (Date) ois.readObject();
		System.out.println("Shopping cart restaurados "+ DateFormat.getDateInstance().format(date));
		
		
	}
	
	/**
	 * Metodo llamada solo durante la serialización
	 * @param oos
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream oos)throws IOException{
		oos.defaultWriteObject();
		oos.writeObject(new Date());
	}
	
	
	

}
