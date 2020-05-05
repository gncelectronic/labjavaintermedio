package ort.utnfrm.entidades;

public class PizzaSimple implements PizzaSimpleInt {
	
	private String nombre;
	private double precio;

	
	
	public PizzaSimple(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	@Override
	public String getNombre() {
		
		return nombre;
	}

	@Override
	public double getPrecio() {
	
		return precio;
	}

}
