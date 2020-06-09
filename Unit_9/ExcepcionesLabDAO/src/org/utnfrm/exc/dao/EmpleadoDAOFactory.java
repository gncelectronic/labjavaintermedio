package org.utnfrm.exc.dao;

public class EmpleadoDAOFactory {
	
	public static EmpleadoDAO createEmpleadoDAO() {
		return new EmpleadoDAOMemoryImpl();
	}

}
