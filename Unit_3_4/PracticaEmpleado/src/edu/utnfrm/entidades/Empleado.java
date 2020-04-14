package edu.utnfrm.entidades;
/*
 * Nuestras clases deben ser inmutable y usar el encapsulamiento
 */
public class Empleado {
	private int empId;
    private String nombre;
    private double salario;
    private String ssn;
    
    //Constructor con parametros  que sustituye al cosntructor por defecto o noargs.
	public Empleado(int empId, String nombre, double salario, String ssn) {
		super();
		this.empId = empId;
		this.nombre = nombre;
		this.salario = salario;
		this.ssn = ssn;
	}
    
    /**
     * Metodo para incremetar el salario de un empleado
     * @param cantidad
     */
	public void incrementarSalario(double cantidad) {
		//Valido que la cantidad a incrementar no sea negativo o cero.
		if(cantidad >0) {
		this.salario += cantidad;
		}else {
			System.out.println("La cantidad a incrementar no puede ser negativa.");
		}
	}
	
	/**
	 * Metodo para asignar el nombre a un Empleado
	 * @param nombre
	 */
	public void  setNombre(String nombre) {
		
		if(nombre != null) {
		this.nombre=nombre;
		}else {
			System.out.println("El nombre no puede ser nulo.");
		}
	}


	//Metodos getters de cada campo de la clase.
	
	public int getEmpId() {
		return empId;
	}


	public String getNombre() {
		return nombre;
	}


	public double getSalario() {
		return salario;
	}


	public String getSsn() {
		return ssn;
	}


	@Override
	public String toString() {
		return "empId=" + empId + ", nombre=" + nombre + ", salario=" + salario + ", ssn=" + ssn ;
	}
	
	
	
	
    
    
    
    

}
