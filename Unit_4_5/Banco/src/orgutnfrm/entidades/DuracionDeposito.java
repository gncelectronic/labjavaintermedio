package orgutnfrm.entidades;
/**
 * Enumeración de la cantidad de dias para los  deposito en cuenta plazo fijos.
 * 
 * @author Gaston
 *
 */
public enum DuracionDeposito {
	
	TRES_MESES(90),
	SEIS_MESES(180);
	
	private int dias;

	
	 private DuracionDeposito(int dias) {
	        this.dias = dias;
	    }
	    
	    public int getDias() {
	        return dias;
	    }
}
