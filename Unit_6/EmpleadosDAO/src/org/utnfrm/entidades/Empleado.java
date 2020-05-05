package org.utnfrm.entidades;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase  Empleado
 * @author Gaston
 *
 */
public  class Empleado {
	
	private  long legajo;
	private  String nombre;
	private String apellido;
	private Date fechaNac;
	private float salario;
	
	
	
	public Empleado(long legajo, String nombre, String apellido, Date fechaNac, float salario) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.salario = salario;
	}
	public long getLegajo() {
		return legajo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public float getSalario() {
		return salario;
	}
	@Override
	public String toString() {
		return "Empleado [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" +  new SimpleDateFormat("dd/MM/yyyy").format(getFechaNac()) 
				+ ", salario=" + NumberFormat.getCurrencyInstance().format((double) getSalario()) + "]";
	}
	
	
	
	
	
	
	

}
