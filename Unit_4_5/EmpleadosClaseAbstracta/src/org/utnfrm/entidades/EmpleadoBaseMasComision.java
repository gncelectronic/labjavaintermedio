package org.utnfrm.entidades;

public class EmpleadoBaseMasComision extends EmpleadoPorComsion {
	
	private double salarioBase;

	public EmpleadoBaseMasComision(long legajo, String nombre, String apellido, String ssn, double ventasBrutas,
			double tarifaComsion, double salarioBase) {
		super(legajo, nombre, apellido, ssn, ventasBrutas, tarifaComsion);
		this.salarioBase=salarioBase;
	}
	
	

	public double getSalarioBase() {
		return salarioBase;
	}



	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}



	@Override
	public double calcularSalario() {
		
		return getSalarioBase() +   super.calcularSalario();
	}



	@Override
	public String toString() {
		return "EmpleadoBaseMasComision ["+ super.toString() + ", salarioBase=" + salarioBase + "]";
	}
	
	
	

}
