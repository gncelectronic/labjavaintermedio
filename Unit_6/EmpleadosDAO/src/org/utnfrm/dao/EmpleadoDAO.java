package org.utnfrm.dao;

import org.utnfrm.entidades.Empleado;

/**
 * Interface que establece los metodos que tendran que implementar las clases
 * que usen esta interfaz
 * 
 * @author Gaston
 *
 */
public interface EmpleadoDAO {

	public void crear(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void eliminar(long legajo);

	public Empleado findById(long legajo);

	public Empleado[] getTodosEmpleados();

}
