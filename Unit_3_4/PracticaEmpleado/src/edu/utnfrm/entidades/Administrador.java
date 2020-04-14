package edu.utnfrm.entidades;

public class Administrador extends Empleado {

	public Administrador(int empId, String nombre, double salario, String ssn) {
		super(empId, nombre, salario, ssn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Administrador ["+ super.toString()+"]";
	}
	
	

}
