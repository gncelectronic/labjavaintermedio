package org.utnfrm.app;

import java.util.Scanner;

import org.utnfrm.servicio.ProductoCollection;

public class ProdCollectionApp {

	public static void main(String[] args) {
		ProductoCollection data  =  new ProductoCollection();
		Scanner keyboard = new Scanner(System.in);
		String nombre;
		int opcion =1, pos;
		double precio;
		
		
		while(opcion!=0) {
			try {
					imprimirMenu();
					System.out.print("Ingrese una opción: ");
					opcion = Integer.parseInt(keyboard.nextLine());
					switch (opcion) {
					case 1: //agregar Producto.
						System.out.print("Ingrese Nombre del producto: ");
						nombre = keyboard.nextLine();
						System.out.print("Ingrese precio del producto: ");
						precio = Double.parseDouble(keyboard.nextLine());
						data.agregar(nombre, precio);
						break;
					case 2: //Remover
						System.out.print("Ingrese Posición del producto a remover: ");
						pos = Integer.parseInt(keyboard.nextLine());
						data.remover(pos);
						break;
					case 3 : // Ver lista
					case 4: // ordenar por nombre
					case 5: //Ordenar por precio
					
					if(opcion == 4) {
						data.orderPorNombre();
					}
					
					else if(opcion == 5) {
						data.ordernarPorPRecio();
						
					}
					System.out.println("-----------------Lista de Productos-----------------");
					for(pos=0 ; pos < data.getSize();pos++) {
						System.out.printf("%3d: %s : $%.2f\n", pos,data.getNombre(pos),data.getPrecio(pos));
						
					}
					System.out.println("----------------------FIN LISTA---------------------");
					break;
					
					
					case 6 : //cambiar producto
					case 7: //cambiar nombre
					case 8: //cambiar precio
					System.out.print("Ingrese la poscisión del producto a cambiar: ");
					pos= Integer.parseInt(keyboard.nextLine());
					nombre = data.getNombre(pos);
					precio = data.getPrecio(pos);
					System.out.printf("El producto es %s: $.2f\n",  nombre, precio);
					if(opcion!=8) {
						System.out.print("Ingrese el nuevo nombre: ");
						nombre = keyboard.nextLine();
					}
					if(opcion!=7) {
						System.out.print("Ingrese el nuevo precio: ");
						precio = Double.parseDouble(keyboard.nextLine());
					}
					
					data.set(pos, nombre, precio);
					break;
					
					case 0 :
						System.out.println("...Terminando");
						break;

					default:
						break;
					}
				
				
			}catch(NumberFormatException e) {
				System.out.println("Entrada incorrecta.");
				
			}
		}

	}
	
	public static void imprimirMenu() {
		System.out.println("-------Seleccione una opción para realizar-------");
		System.out.printf(
			   "  %-20s%-20s%-20s\n  %-22s%-22s%-22s\n"
			  +"  %-20s%-20s%-20s\n  ",
			  "1. Agregar Producto", "2. Remover Producto", "3. Ver lista",
		      "4. Ordenar por nombre","5. Ordenar por precio", "6. Cambiar producto",
			  "7. Cambiar nombre", "8. Cambiar precio", "0. Salir");
		
	}

}
