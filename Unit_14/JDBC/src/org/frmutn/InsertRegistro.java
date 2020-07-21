package org.frmutn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
/**
 * Inserta un registro en la tabla Libros
 * @author Gaston
 *
 */
public class InsertRegistro {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(
				"jdbc:derby:e:/UTN/Proydesa/Java Intermedio/Laboratorios/Unit_14/database_derby/testdb");
		PreparedStatement ps = con.prepareStatement("INSERT INTO LIBROS (TITULO,PRECIO) VALUES(?,?)");
		ps.setString(1, "Como programar en Java");
		ps.setDouble(2, 2500.50);
		ps.executeUpdate();
		
		ps.setString(1, "Como usar JDBC");
		ps.setDouble(2, 356.8);
		ps.executeUpdate();
		
		
		System.out.println("Registro insertado");
		
		ps.close();
		con.close();
		
		
				
	}

}
