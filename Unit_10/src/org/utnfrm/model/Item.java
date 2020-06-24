package org.utnfrm.model;

import java.io.Serializable;

public class Item  implements Serializable{

	private static final long serialVersionUID = 4L;
	private int id;
	private String descripcion;
	private double precio;
	public Item(int id, String descripcion, double precio) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getId() {
		return id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	
	
	
}
