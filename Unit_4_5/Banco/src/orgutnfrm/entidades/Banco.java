package orgutnfrm.entidades;


/**
 * Entidad que modela el concepto de Banco el cual tiene uno o mas clientes.
 * @author Gaston
 *
 */
public class Banco {
	  private static final Banco instancia = new Banco();

	private Cliente[] clientes;
	private int numeroDeClientes;

	public Banco() {
		super();
		clientes = new Cliente[10];
		numeroDeClientes = 0;

	}

	public static Banco getInstancia() {
		return instancia;
	}
	
	public void agregarCliente(String nombre, String apellido) {
		int i = numeroDeClientes++;
		clientes[i] =new Cliente(nombre, apellido);
	}

	public int getNumeroDeClientes() {
		return numeroDeClientes;
	}
	
	public Cliente getCliente(int indiceCliente) {
		return clientes[indiceCliente];
		
	}
}
