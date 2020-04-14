package edu.utnfrm.entidades;
/**
 *  Clase Director subclase de Gerente.
 * @author Gaston
 *
 */
public class Director extends Gerente {
	
	private double presupuesto;

	public Director(int empId, String nombre, double salario, String ssn, String nombreDepartamento, double presupuesto) {
		super(empId, nombre, salario, ssn, nombreDepartamento);
		this.presupuesto=presupuesto;
	}
	
	

	public double getPresupuesto() {
		return presupuesto;
	}



	@Override
	public String toString() {
		return "Director ["+ super.toString() + ", presupuesto=" + presupuesto + "]";
	}
	
	

}
