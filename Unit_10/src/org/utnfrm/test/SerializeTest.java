package org.utnfrm.test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;

import org.utnfrm.model.Item;
import org.utnfrm.model.ShoppingCart;

public class SerializeTest {

	public static void main(String[] args) {
		String directory ="C:\\Users\\gncel\\wp_java_class\\";
		String cartId=null;
		ShoppingCart cart = null;
		System.out.println("Ingrese un Id para cart para crear el archivo a serializar o q para salir");
		try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
			cartId = in.readLine();
			if(cartId.equals("q")) {
				System.exit(0);
			}
			
			cart = new ShoppingCart(new Integer(cartId).intValue());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cart.addItem(new Item(100, "Camisa azul", 345.56));
		cart.addItem(new Item(101, "Camisa negra", 600.80));
		cart.addItem(new Item(102, "Remera ", 1050.5));
		
		System.out.println("Shopping cart: "+ cartId + "contiene: "+ cart.getCartSize()+ " items");
		System.out.println("Shopping cart Total: "+ NumberFormat.getCurrencyInstance().format(cart.getCartTotal()));
		
		String cartFile = directory + "cart" + cart.getCartId() + ".ser";
		try(FileOutputStream fos = new FileOutputStream(cartFile);
				ObjectOutputStream o = new ObjectOutputStream(fos)){
			
			o.writeObject(cart);
			
		} catch (IOException e) {
			System.out.println("Exception serializing "+ cartFile + ": "+ e);
			System.exit(-1);
		}
		System.out.println("Serializacion realizada correctamente para shopping cart id:"+ cart.getCartId());
	}

}
