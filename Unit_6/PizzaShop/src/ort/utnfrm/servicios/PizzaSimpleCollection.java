package ort.utnfrm.servicios;

import java.util.Arrays;

import ort.utnfrm.entidades.PizzaSimple;
import ort.utnfrm.entidades.PizzaSimpleInt;

public class PizzaSimpleCollection {
	private PizzaSimpleInt[] menu;
	
	

	public PizzaSimpleCollection() {
		super();
		menu = new PizzaSimple[0];
	}

	public void agregar(String nombre, double precio) {
		PizzaSimpleInt[] nuevaLista = Arrays.copyOf(menu, menu.length + 1);
		nuevaLista[menu.length] = new PizzaSimple(nombre, precio);
		menu = nuevaLista;
	}

	public void remover(int indice) {
		PizzaSimpleInt[] nuevaLista = Arrays.copyOf(menu, menu.length - 1);
		for (int pos = indice + 1; pos < menu.length; pos++) {
			nuevaLista[pos - 1] = menu[pos];

		}

		menu = nuevaLista;

	}
	
	
	public  void imprimirMenu() {
		for(int i =0; i < menu.length; i++) {
			
			System.out.printf("%3d:%s$%.2f%n",i,menu[i].getNombre(), menu[i].getPrecio());
		}
		
	}

}
