package orgutnfrm.entidades;

/**
 * Entidad que modela un cliente del Banco con una o mas cuentas.
 * 
 * @author Gaston
 *
 */
public class Cliente {
	private String nombre;
	private String apellido;
	private Cuenta[] cuentas;
	private int numeroDeCuentas;

	public Cliente(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;

		cuentas = new Cuenta[10];
		numeroDeCuentas = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void agregarCuenta(Cuenta cuenta) {
		int i = numeroDeCuentas++;
		cuentas[i] = cuenta;
	}

	public Cuenta getCuentas(int indiceCuenta) {
		return cuentas[indiceCuenta];
	}

	public int getNumeroDeCuentas() {
		return numeroDeCuentas;
	}

}
