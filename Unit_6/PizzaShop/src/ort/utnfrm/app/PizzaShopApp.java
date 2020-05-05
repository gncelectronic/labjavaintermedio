package ort.utnfrm.app;

import java.util.Scanner;

import ort.utnfrm.servicios.PizzaSimpleCollection;

public class PizzaShopApp {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		PizzaSimpleCollection data;
		
		data = new PizzaSimpleCollection();
		String input="";
		do {
			System.out.println("Ingrese un opción con la primera letra de la palabra");
			System.out.println("[I]mprimir, [A]gregar, [B]orrar, [S]alir");
			input = keyboard.nextLine();
			switch(input.charAt(0)) {
			case 'I' : data.imprimirMenu(); break;
			case 'A': 
				System.out.println("Ingrese nombre de la pizza: ");
				String nombre = keyboard.nextLine();
				System.out.println("Ingrese precio: ");
				double precio = Double.parseDouble(keyboard.nextLine());
				data.agregar(nombre, precio);
				break;
				
			case 'B':
				System.out.println("Ingrese indice: ");
				data.remover(Integer.parseInt(keyboard.nextLine()));
			
			}
			
		}while(!input.startsWith("S"));
	}

}
