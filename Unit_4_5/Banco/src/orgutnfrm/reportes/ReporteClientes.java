package orgutnfrm.reportes;


import orgutnfrm.entidades.Banco;
import orgutnfrm.entidades.Cliente;
import orgutnfrm.entidades.Cuenta;
/**
 * Clase que  representa a un servicio el cual realiza el reporte de clientes del banco
 * @author Gaston
 *
 */
public class ReporteClientes {
	
	private Banco banco;
	
	
	
	
	public Banco getBanco() {
		return banco;
	}




	public void setBanco(Banco banco) {
		this.banco = banco;
	}




	public   void generarReporte() {
		  System.out.println("\t\t\tREPORTE DE CLIENTES");
	        System.out.println("\t\t\t================");
	        
	        for (int i=0; i< banco.getNumeroDeClientes();i++) {
	            Cliente cliente = banco.getCliente(i);

	           
	            System.out.println();
	            System.out.println("Cliente: "
	                    + cliente.getNombre() + ", "
	                    + cliente.getApellido());

	          
	            for (int j = 0; j < cliente.getNumeroDeCuentas(); j++) {
	                Cuenta account = cliente.getCuentas(j);
	                
	                System.out.println("    " + account);
	            }
	        }
	}

}
