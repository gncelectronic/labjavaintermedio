package org.utnfrm.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.text.NumberFormat;
import java.util.List;

import org.utnfrm.model.Item;
import org.utnfrm.model.ShoppingCart;

public class DeserializeTest {

	public static void main(String[] args) {
		String directory ="C:\\Users\\gncel\\wp_java_class\\";
		String cartId= null;
		System.out.println("Ingrese el id del cart File para deserializar o q para salir.");
		try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
			cartId = in.readLine();
			if(cartId.equals("q")) {
				System.exit(0);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String cartFile=directory + "cart" + cartId + ".ser";
		ShoppingCart cart = null;
		try(FileInputStream fis = new FileInputStream(cartFile);
				
				ObjectInputStream in = new ObjectInputStream(fis)){
			
			cart = (ShoppingCart) in.readObject();
			
			
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Exception deserializing "+ cartFile + ":" + e);
			System.exit(-1);
		}
		
		System.out.println("Deserializacion realizada con exito con cart id: " + cart.getCartId());
		System.out.println("Shopping cart contiene: ");
		List<Item> items = cart.getItems();
		for (Item item : items) {
			System.out.println(item);
		}
		
		System.out.println("Shopping car total: "+ NumberFormat.getCurrencyInstance().format(cart.getCartTotal()));

	}

}
