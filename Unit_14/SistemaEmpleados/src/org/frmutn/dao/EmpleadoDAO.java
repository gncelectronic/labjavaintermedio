package org.frmutn.dao;

import org.frmutn.entidades.Empleado;

/**
 * Interface que establece los metodos que tendran que implementar las clases
 * que usen esta interfaz
 * 
 * @author Gaston
 *
 */
public interface EmpleadoDAO {

	public void crear(Empleado empleado) throws DAOException;

	public void actualizar(Empleado empleado) throws DAOException;

	public void eliminar(long legajo) throws DAOException;

	public Empleado findById(long legajo) throws DAOException;

	public Empleado[] getTodosEmpleados() throws DAOException;

}
