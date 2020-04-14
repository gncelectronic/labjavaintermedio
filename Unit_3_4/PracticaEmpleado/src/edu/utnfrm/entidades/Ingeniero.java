package edu.utnfrm.entidades;

public class Ingeniero extends Empleado {

	public Ingeniero(int empId, String nombre, double salario, String ssn) {
		super(empId, nombre, salario, ssn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ingeniero ["+ super.toString()+"]";
	}
	
	

}
