package org.frmutn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 * Crea una tabla en el esquema APP
 * @author Gaston
 *
 */
public class CreateTable {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(
				"jdbc:derby:e:/UTN/Proydesa/Java Intermedio/Laboratorios/Unit_14/database_derby/testdb");
		Statement st = con.createStatement();
		st.executeUpdate("DROP TABLE LIBROS");
		st.executeUpdate("CREATE TABLE LIBROS (ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, TITULO VARCHAR(50), PRECIO DOUBLE)");
		
		System.out.println("Tabla  creada");
		
		st.close();
		con.close();
		
		
				
	}

}
