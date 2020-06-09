
package exc;

import static java.lang.invoke.MethodHandles.throwException;

/**
 *
 * @author Gaston
 */
public class UsandoExcepciones {
    
    public static void main(String [] args){
        try{
            
           throwException();
          
        }catch(Exception ex){
            System.err.println("Excepcion manejada en el metodo main");
        }
         noLanzarException();
    }
    /**
     * Demostracion de try catch y finally
     * @throws Exception 
     */
    public static void throwException()throws Exception{
        try{
            System.out.println("Metodo throwException");
            //generar Exceptcion
            throw new Exception();
        
        }catch(Exception ex){
            System.err.println("Excepcion manejada  desde el metodo throwException");
            throw ex;
        }finally{
            System.out.println("Finally ejecutado en throwException");
        }
    }
    
    public static void noLanzarException(){
        
      try{  
       
          System.out.println("Metodo noLanzarException");
      }catch(Exception ex){
          System.err.println(ex);
      }
        finally{
            System.err.println("Finally ejecutado en el metodo noLanzarException");
}
      
        System.out.println("Fin del metodo noLanzarException");
    }
}
