package org.utnfrm.exc.dao;
/**
 * 
 * @author Gaston
 *
 */
public class DAOException extends Exception {
	
	public DAOException() {
		super();
	}
	
	public DAOException(String mensaje) {
		super(mensaje);
	}
	
	public DAOException(Throwable causa) {
		super(causa);
	}
	
	public DAOException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

}
