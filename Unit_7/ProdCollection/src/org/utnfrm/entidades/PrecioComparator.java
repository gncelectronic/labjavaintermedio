package org.utnfrm.entidades;

import java.util.Comparator;

public class PrecioComparator implements Comparator<Producto>{

	@Override
	public int compare(Producto arg0, Producto arg1) {
		
		return (int) (arg0.getPrecio() - arg1.getPrecio());
	}

}
