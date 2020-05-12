package org.utnfrm.entidades;

public class Producto implements Comparable<Producto> {
	
	private String nombre;
	private double precio;
	
	

	public Producto(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}


	
	public String getNombre() {
		return nombre;
	}



	public double getPrecio() {
		return precio;
	}
	
	



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	/**
	 * Implementacion del metodo de la interfaz Comparable
	 */

	@Override
	public int compareTo(Producto arg0) {
		
		return  nombre.compareTo(arg0.nombre);
	}

}
