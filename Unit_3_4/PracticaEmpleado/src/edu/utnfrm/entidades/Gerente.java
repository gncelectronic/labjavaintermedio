package edu.utnfrm.entidades;
/**
 * Clase Gerente subclase de Empleado
 * @author Gaston
 *
 */
public class Gerente extends Empleado {

	private String nombreDepartamento;

	public Gerente(int empId, String nombre, double salario, String ssn, String nombreDepartamento) {
		super(empId, nombre, salario, ssn);
		this.nombreDepartamento = nombreDepartamento;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	@Override
	public String toString() {
		return "Gerente ["+ super.toString()+", nombreDepartamento=" + nombreDepartamento + "]";
	}


	
	
	

}
