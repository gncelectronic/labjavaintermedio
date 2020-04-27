package orgutnfrm.entidades;

import java.util.Calendar;
import java.util.Date;
/**
 * Clase que modela un plazo fijo.
 * 
 * @author Gaston
 *
 */
public class PlazoFijo extends Cuenta {

	private final Date fechaVencimiento;

	public PlazoFijo(double monto, DuracionDeposito vencimiento) {
		super(monto);
		// Uso la clase Calendar para sumar fechas
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, vencimiento.getDias());
		this.fechaVencimiento = cal.getTime();
	}

	@Override
	public boolean retiro(double monto) {
		Date hoy = new Date();
		if (hoy.after(fechaVencimiento)) {
			if (monto <= balance) {
				balance -= monto;
				return true;
			} else
				return false;
		} else {

			return false;
		}

	}

	@Override
	public String getDescripcion() {
		  return "Tiempo de deposito de la cuenta: " + fechaVencimiento;
	}

}
