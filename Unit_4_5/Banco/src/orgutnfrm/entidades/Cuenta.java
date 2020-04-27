package orgutnfrm.entidades;
/**
 * Entidad que representa una cuenta bancaria
 * 
 * @author Gaston
 *
 */
public abstract class Cuenta {

	protected double balance;
	
	
	
	public Cuenta(double balance) {
		super();
		this.balance = balance;
	}

	/**
	 * Metodo que realiza un deposito bancario
	 * @param monto
	 */
	public void deposito(double monto) {
		balance += monto;
	}
	
	public abstract boolean retiro(double monto);
	
	public abstract String getDescripcion();
	
	

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return  getDescripcion() + ", el balance de la cuenta es=" + balance ;
	}
	
	
		
	
}
