package org.utnfrm.entidades;

public class EmpleadoAsalariado extends Empleado {

	private double salarioSemanal;

	public EmpleadoAsalariado(long legajo, String nombre, String apellido, String ssn,double salarioSemanal) {
		
		super(legajo, nombre, apellido, ssn);
		
		this.salarioSemanal = salarioSemanal;
		

	}

	public double getSalarioSemanal() {
		return salarioSemanal;
	}

	public void setSalarioSemanal(double salarioSemanal) {
		if (salarioSemanal < 0.0) {
			System.out.println("El salario semanal debe ser mayor que cero");
		} else {
			this.salarioSemanal = salarioSemanal;
		}

	}

	@Override
	public double calcularSalario() {
		//
		return salarioSemanal;
	}

	@Override
	public String toString() {
		return "EmpleadoAsalariado ["+ super.toString() +", salarioSemanal=" + salarioSemanal + "]";
	}
	
	
	

}
