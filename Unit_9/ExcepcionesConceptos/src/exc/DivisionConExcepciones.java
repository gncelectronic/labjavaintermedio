
package exc;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gaston
 */
public class DivisionConExcepciones {
    
    public static int cociente(int numerador, int denominador) throws ArithmeticException{
        return numerador/denominador;
    }
    
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        do{
           try{ 
            System.out.println("Ingrese un numero: ");
            int numerador = scanner.nextInt();
            System.out.println("Ingrese otro numero: ");
            int denominador = scanner.nextInt();
            int resultado = cociente(numerador, denominador);
               System.out.printf("El resultado %d/%d=%d%n",numerador, denominador, resultado);
               loop=false;
           }catch(InputMismatchException ex){
               System.err.printf("%nExcepcion: %s%n",ex);
               scanner.nextLine();
               System.out.printf("Debe Ingresar un valor entero, Por favor intente de nuevo %n%n");
               
           }catch(ArithmeticException ex){
               System.err.printf("%nExcepcion: %s%n",ex.getMessage());
               System.out.printf("Cero no es un denominador valido. Por favor intente de nuevo %n%n");
           }
        }while(loop);
        }
        
    
}
