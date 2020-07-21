package org.frmutn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * Inserta un registro en la tabla Libros
 * @author Gaston
 *
 */
public class DeleteRegistro {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(
				"jdbc:derby:e:/UTN/Proydesa/Java Intermedio/Laboratorios/Unit_14/database_derby/testdb");
		PreparedStatement ps = con.prepareStatement("Delete from libros where id = ?");
		ps.setInt(1, 102);
		int rta= ps.executeUpdate();
		if(rta ==1) {
			System.out.println("Registro eliminado");
			
		}
		
						
		
		
		ps.close();
		con.close();
		
		
				
	}

}
