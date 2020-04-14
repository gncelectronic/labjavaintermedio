package edu.utnfrm;

import java.util.Scanner;

public class Calculadora {
	
	static int numero1;
	static int numero2;
	static int resultado;
	static char operacion;
	
	
    public static void main(String[] args) {
    	
    	Scanner entrada  = new Scanner(System.in);
    	System.out.print("Escriba el primer numero entero:");
    	numero1 = entrada.nextInt();
    	
    	System.out.print("Escriba el segundo numero entero:");
    	
    	numero2 = entrada.nextInt();
    	
    	System.out.print("Escriba la operación aritmetica:"
    			+ "\n Suma ingrese: +"
    			+ "\n Resta ingrese: -"
    			+ "\n Multiplicación ingrese: *"
    			+ "\n Division ingrese: /"
    			+ "\n:");
    	operacion = entrada.next().charAt(0);
    	
    	if(operacion == '+') {
    		resultado = numero1 + numero2;
    		System.out.printf("La suma de:" + numero1 + "+" + numero2 +"=%d", resultado);
    	}
    	
    	else if(operacion == '-') {
    		resultado = numero1 - numero2;
    		System.out.printf("La resta de:" + numero1 + "-" + numero2 +"=%d", resultado);
    	}
    	
    	else if(operacion == '*') {
    		resultado = numero1 * numero2;
    		System.out.printf("La multiplicación de:" + numero1 + "*" + numero2 +"=%d", resultado);
    	}
    	else if(operacion == '/') {
    		resultado = numero1 / numero2;
    		System.out.printf("La resta de:" + numero1 + "/" + numero2 +"=%d", resultado);
    	}
    }
}
