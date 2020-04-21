package org.utnfrm.entidades;

public class EmpleadoPorComsion extends Empleado {

	private double ventasBrutas;
	private double tarifaComision;
	public EmpleadoPorComsion(long legajo, String nombre, String apellido, String ssn, double ventasBrutas, double tarifaComsion) {
		super(legajo, nombre, apellido, ssn);
		this.ventasBrutas= ventasBrutas;
		this.tarifaComision =tarifaComsion;
	
	}
	
	

	public double getVentasBrutas() {
		return ventasBrutas;
	}



	public void setVentasBrutas(double ventasBrutas) {
		
		if(ventasBrutas <0.0) {
		this.ventasBrutas = ventasBrutas;
		}else
			this.ventasBrutas= ventasBrutas;
		
		
	}



	public double getTarifaComision() {
		
		return tarifaComision;
	}



	public void setTarifaComision(double tarifaComision) {
		
		
		this.tarifaComision = tarifaComision;
	}


	/**
	 * calculo de salario Empleado por comisión.
	 */
	@Override
	public double calcularSalario() {
		
		return getTarifaComision() * getVentasBrutas();
	}



	@Override
	public String toString() {
		return "EmpleadoPorComsion ["+ super.toString() +", ventasBrutas=" + ventasBrutas + ", tarifaComision=" + tarifaComision + "]";
	}
	
	
	

}
