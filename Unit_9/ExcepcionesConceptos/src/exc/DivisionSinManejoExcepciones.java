
package exc;

import java.util.Scanner;

/**
 *
 * @author Gaston
 */
public class DivisionSinManejoExcepciones {

    
    public static int cociente(int numerador, int denominador){
        return numerador/denominador; //posible division con cero
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int numerador = scanner.nextInt();
        System.out.println("Ingrese otro numero: ");
        int denominador = scanner.nextInt();
        int resultado = cociente(numerador,denominador);
        System.out.printf("El resultado %d/%d = %d%n",numerador,denominador,resultado);
    }
    
}
