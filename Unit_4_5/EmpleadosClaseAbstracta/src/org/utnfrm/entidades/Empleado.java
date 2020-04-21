package org.utnfrm.entidades;
/**
 * Clase Abstracta Empleado
 * @author Gaston
 *
 */
public abstract class Empleado {
	
	private  long legajo;
	private  String nombre;
	private String apellido;
	private String ssn;
	
	
	
	
	public Empleado(long legajo, String nombre, String apellido, String ssn) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ssn = ssn;
	}

	public abstract  double calcularSalario();

	@Override
	public String toString() {
		return "legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", ssn=" + ssn ;
	}
	
	
	

}
