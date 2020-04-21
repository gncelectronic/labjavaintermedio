package org.utnfrm.entidades;

public class EmpleadoPorHoras extends Empleado {
	

	//precio o tarifa por hora trabajada.
	private double tarifa;
	//Total horas trabjadas
	private double horas;
	

	public EmpleadoPorHoras(long legajo, String nombre, String apellido, String ssn, double tarifa, double horas) {
		super(legajo, nombre, apellido, ssn);
		this.horas = horas;
		this.tarifa = tarifa;
	}
	
	


	
	public double getTarifa() {
		return tarifa;
	}





	public void setTarifa(double tarifa) {
		
		this.tarifa = tarifa;
	}





	public double getHoras() {
		return horas;
	}





	public void setHoras(double horas) {
		this.horas = horas;
	}




    /**
     * 
     * Calculo del salario para un empleado por horas
     */
	@Override
	public double calcularSalario() {
		 if(getHoras() <=40) {
			 return getTarifa() * getHoras();
		 }else {
			 return 40 * getTarifa() + (getHoras() -40) * getTarifa() *1.5;
		 }
		
	}





	@Override
	public String toString() {
		return "EmpleadoPorHoras ["+ super.toString()+", tarifa=" + tarifa + ", horas=" + horas + "]";
	}
	
	

}
