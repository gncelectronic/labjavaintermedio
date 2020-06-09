package org.utnfrm.exc.dao;

import org.utnfrm.exc.model.Empleado;

public interface EmpleadoDAO extends AutoCloseable {

	public void add(Empleado emp) throws DAOException;
	public void update(Empleado emp)throws DAOException;
	public void delete(int id)throws DAOException;
	public Empleado findById(int id)throws DAOException;
	public Empleado[] getAllEmpleados()throws DAOException;
}
