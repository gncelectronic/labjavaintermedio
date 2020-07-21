package org.frmutn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *  Prueba de creación de una base de datos usando el motor Derby   
 * @author Gaston
 *
 */
public class TestConnection {

	public static void main(String[] args) {
		Connection con;
		try {
			con = DriverManager.getConnection(
					"jdbc:derby:E:/UTN/Proydesa/Java Intermedio/Laboratorios/Unit_14/database_derby/testdb; create=true");
			System.out.println("Conectado a la base de datos Derby!!");
			con.close();
		} catch (SQLException e) {
			System.out.println("Error:"+ e.getErrorCode()+", "+ e.getMessage());
			e.printStackTrace();
		}

	}

}
