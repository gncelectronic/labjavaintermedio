package org.frmutn.dao;
/**
 * Clase que implemtenta el patron Factory.
 * @author Gaston
 *
 */
public class EmpleadoDAOFactory {

	public static EmpleadoDAO crearEmpleadoDAO() {
		return new EmpleadoDAOJDBCImpl();
	}
}
