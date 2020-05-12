package org.utnfrm.servicio;

import java.util.ArrayList;

import org.utnfrm.entidades.PrecioComparator;
import org.utnfrm.entidades.Producto;

/**
 * Clase que  tiene los metodos del negocio para agregar, eliminar, ordenar y modificar un producto
 * @author Gaston
 *
 */
public class ProductoCollection {
	private ArrayList<Producto> lista;

	public ProductoCollection() {
		super();
		lista = new ArrayList<Producto>();
	}
	
	public int getSize() {
		return lista.size();
	}
	
	public String getNombre(int index) {
		return lista.get(index).getNombre();
	}
	
	public double getPrecio(int index) {
		return lista.get(index).getPrecio();
	}
	
	public void  agregar(String nombre, double precio) {
		lista.add(new Producto(nombre, precio));
	}
	
	public void remover(int index) {
		lista.remove(index);
	}
	
	public void  set( int index,  String nombre, double precio) {
		lista.get(index).setNombre(nombre);
		lista.get(index).setPrecio(precio);
	}
	
	
	
	public  void orderPorNombre() {
		java.util.Collections.sort(lista);
	}
	
	public void ordernarPorPRecio() {
		java.util.Collections.sort(lista, new PrecioComparator());
	}
	

}
