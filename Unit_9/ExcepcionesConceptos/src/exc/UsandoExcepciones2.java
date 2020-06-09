
package exc;

/**
 *
 * @author Gaston
 */
public class UsandoExcepciones2 {
    public static void main(String [] args){
        try{
            metodo1();
        }catch(Exception ex){
            System.err.printf("%s%n%n",ex.getMessage());
            ex.printStackTrace();
            StackTraceElement[] traceElements = ex.getStackTrace();
            System.out.printf("%nStack trace desde getStackTrace(): %n");
            System.out.println("Class\t\tFile\t\t\tLine\tMethodo");
            for(StackTraceElement element: traceElements){
                System.out.printf("%s\t",element.getClassName());
                 System.out.printf("%s\t",element.getFileName());
                  System.out.printf("%s\t",element.getLineNumber());
                   System.out.printf("%s\n",element.getMethodName());
            }
        }
    }

    private static void metodo1() throws Exception {
      metodo2();
    }

    private static void metodo2()throws Exception {
       metodo3();
    }

    private static void metodo3()throws Exception {
        throw new Exception("Excepcion lanzada en metodo 3"); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
