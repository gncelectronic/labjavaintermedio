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
public class MostrarRegistros {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(
				"jdbc:derby:e:/UTN/Proydesa/Java Intermedio/Laboratorios/Unit_14/database_derby/testdb");
		PreparedStatement ps = con.prepareStatement("Select * from libros");
		ResultSet rs = ps.executeQuery();
		System.out.printf("%10s %80s %10s","ID","TITULO","PRECIO");
		System.out.println();	
		while(rs.next()) {
		System.out.printf("%10d",rs.getInt("id") );
		System.out.printf("%80s", rs.getString("titulo"));
		System.out.printf( "%10.2f%n",rs.getDouble("precio"));
		System.out.println();	
			
		}
		
				
		
		rs.close();
		ps.close();
		con.close();
		
		
				
	}

}
