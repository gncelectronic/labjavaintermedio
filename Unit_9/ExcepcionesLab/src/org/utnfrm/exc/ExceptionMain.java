package org.utnfrm.exc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
 * @author Gaston
 *
 */
public class ExceptionMain {

	public static void main(String[] args) {
		try {
		System.out.println("Leyendo archivo: " +args[0]);
		
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("no se ha especificado un archivo, saliendo!.");
			System.exit(1);
		}
	
		//Try  with resource
		try (BufferedReader b = new BufferedReader(new FileReader(args[0]));){
			String s = null;
			while ((s = b.readLine())!=null) {
				
				System.out.println(s);
				
			}
		} 
		catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado, saliendo!.");
			System.exit(1);
		}
		catch (IOException e) {
			System.out.println("Error al leer el archivo: "+ e.getMessage());
			System.exit(1);
		}
		
		

	}

}
