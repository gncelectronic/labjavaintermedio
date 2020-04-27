package orgutnfrm.app;

import orgutnfrm.entidades.Banco;
import orgutnfrm.entidades.Cliente;
import orgutnfrm.entidades.CuentaCorriente;
import orgutnfrm.entidades.DuracionDeposito;
import orgutnfrm.entidades.PlazoFijo;
import orgutnfrm.reportes.ReporteClientes;
/**
 * Clase ejecutable de la aplicación Banco
 * @author Gaston
 *
 */
public class BancoApp {
	

	public static void main(String[] args) {
		 ReporteClientes report = new ReporteClientes();
		Banco bna = Banco.getInstancia();
		
		bna.agregarCliente("Roberto", "Flores");
		Cliente cliCtaCte01 = bna.getCliente(0);
		cliCtaCte01.agregarCuenta(new CuentaCorriente(10000, 5000));
		
		
		bna.agregarCliente("Juan", "Perez");
		Cliente cliPlazoFijo01 = bna.getCliente(1);
		cliPlazoFijo01.agregarCuenta(new PlazoFijo(80000, DuracionDeposito.SEIS_MESES));
		
		report.setBanco(bna);
		
	
		
		
		
			report.generarReporte();
			
			
			//Cliente 01 hace una retiro de $2000
			if(cliCtaCte01.getCuentas(0).retiro(2000)) {
				System.out.println("El cliente: "+ cliCtaCte01.getApellido()+ ",retira 2000");
			}
			
			if(!cliPlazoFijo01.getCuentas(0).retiro(5000)) {
				System.out.println("El cliente:" + cliPlazoFijo01.getApellido() + ", no puede retirar dinero porque no se cumplio el plazo de vencimiento");
			}else {
				
			}
			
			
			
			report.generarReporte();

	}

}
