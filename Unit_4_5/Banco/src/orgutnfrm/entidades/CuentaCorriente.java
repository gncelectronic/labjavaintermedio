package orgutnfrm.entidades;
/**
 * Clase que modela una cuenta corriente del Banco
 * 
 * @author Gaston
 *
 */
public class CuentaCorriente extends Cuenta {
	  private final double MONTO_MAX_DESCUBIERTO;
	  ;
	public CuentaCorriente(double balance, double montoDescubierto) {
		super(balance);
		this.MONTO_MAX_DESCUBIERTO = montoDescubierto;
		
	}

	@Override
	public boolean retiro(double monto) {
		if(monto <= balance + MONTO_MAX_DESCUBIERTO) {
			balance -=monto;
			return true;
		}else {
		return false;
		}
	}

	@Override
	public String getDescripcion() {
		
		return "Cuenta Corriente";
	}

}
