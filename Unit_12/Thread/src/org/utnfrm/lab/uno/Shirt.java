package org.utnfrm.lab.uno;

public class Shirt {
	private String id="";
	private String descripcion="";
	private String color="";
	private String size="";
	public Shirt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shirt(String id, String descripcion, String color, String size) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.color = color;
		this.size = size;
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
	public String getSize() {
		return size;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Shirt id: ");
		sb.append(getId());
		sb.append("\nDescripcion");
		sb.append(getDescripcion());
		sb.append("\nColor: ");
		sb.append(getColor());
		sb.append("\n Size: ");
		sb.append(getSize());
		sb.append("\n");
		return sb.toString();
	}
	
	
	

	
	
}
