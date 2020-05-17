package org.utnfrm.entidad;

public class Shirt {
	private String id="";
	private String descripcion="";
	private String color="";
	private String tamaño;
	private long cantidad =0;
	
	
	public Shirt(String id, String descripcion, String color, String tamaño) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.color = color;
		this.tamaño = tamaño;
	}
	
	
	
	public void addItems(long cantidad) {
		this.cantidad +=cantidad;
	}
	
	public void remoterItems(long cantidad) {
		if((this.cantidad -cantidad )>0) {
			this.cantidad -=cantidad;
		}else {
			System.out.println("Error Inventario negativo.");
		}
	}
	
	


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(256);
		sb.append("Shirt ID:").append(this.getId()).append("\n");
		sb.append("DEscripción: ").append(this.getDescripcion()).append("\n");
		sb.append("Color: ").append(this.color).append("\n");
		sb.append("Tamaño: ").append(this.tamaño).append("\n");
		sb.append("Sock: ").append(this.cantidad).append("\n");
		return sb.toString();
	}



	public String getId() {
		return id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public String getColor() {
		return color;
	}


	public String getTamaño() {
		return tamaño;
	}


	public long getCantidad() {
		return cantidad;
	}
	
	
	
	
	

}
