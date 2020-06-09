package org.utnfrm.exc.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Gaston
 *
 */
public class Empleado {

	private int id;
	private String nombre;
	private String apellido;
	private Date fechaNac;
	private float salario;
	
	public Empleado() {}
	
	public Empleado(int id, String nombre, String apellido, Date fechaNac, float salario) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.salario = salario;
	}

	public int getId() {
		return id;
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
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido 
				+ ", fechaNac=" + new SimpleDateFormat("dd/MM/yyyy").format(getFechaNac())
				+ ", salario=" +NumberFormat.getCurrencyInstance().format((double) salario) + "]";
	}
	
	
		
	
}
