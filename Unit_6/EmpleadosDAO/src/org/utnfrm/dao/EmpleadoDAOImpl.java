package org.utnfrm.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.utnfrm.entidades.Empleado;
/**
 * Clase que implementa la interface EmpleadoDAO.
 * @author Gaston
 *
 */
public class EmpleadoDAOImpl implements EmpleadoDAO {

	private Empleado[] listaEmpleados;

	public EmpleadoDAOImpl() {
		super();
		this.listaEmpleados = new Empleado[0];
	}

	@Override
	public void crear(Empleado empleado) {
		Empleado[] nuevaLista = Arrays.copyOf(listaEmpleados, listaEmpleados.length + 1);
		nuevaLista[listaEmpleados.length] = empleado;
		listaEmpleados = nuevaLista;

	}

	@Override
	public void actualizar(Empleado empleado) {

		for (int i = 0; i < listaEmpleados.length; i++) {
			if (listaEmpleados[i].getLegajo() == empleado.getLegajo()) {
				System.out.println("Actualizando Empleado con legajo: " + empleado.getLegajo());
				listaEmpleados[i] = empleado;

			}

		}

	}

	@Override
	public void eliminar(long legajo) {
		List<Empleado> newLista =new ArrayList<>(Arrays.asList(listaEmpleados)); 
	
		Iterator<Empleado> iter = newLista.iterator();
		while(iter.hasNext()) {
			Empleado emp = iter.next();
			if(emp.getLegajo() == legajo) {
				iter.remove();
			}
		}
		
		listaEmpleados = newLista.toArray(new Empleado[newLista.size()]);

	}

	@Override
	public Empleado findById(long legajo) {
		Empleado rta = null;
		for (int i = 0; i < listaEmpleados.length; i++) {
			if (listaEmpleados[i].getLegajo() == legajo) {
				rta = listaEmpleados[i];
			}
		}

		return rta;
	}

	@Override
	public Empleado[] getTodosEmpleados() {

		return listaEmpleados;
	}

}
