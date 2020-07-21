package org.frmutn.empleados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Antes de correr este programa se debe haber creado la base de datos
 *  connect 'jdbc:derby://localhost:1527/empleadosdb;create=true';
 *  
 *   insert into empleados (NOMBRE,APELLIDO,FECHA_NACIMIENTO,SALARIO) values('Pedro','Robles', DATE('1986-03-12'),1500.68)
 * @author Gaston
 *
 */
public class SimpleJDBCTestEmpleado {

	public static void main(String[] args) {
		String url= "jdbc:derby://localhost:1527/empleadosdb";
		String query= "SELECT * FROM EMPLEADOS";
		try(Connection con = DriverManager.getConnection(url);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query)){
			
			System.out.printf("%10s %30s %30s %20s %10s","ID","NOMBRE","APELLIDO","FECHA NACIMIENTO","SALARIO");
			System.out.println();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Date fechaNacimiento = rs.getDate("fecha_nacimiento");
				double salario = rs.getDouble("salario");
				System.out.printf("%10d %30s %30s %4$15td/%4$tm/%4$tY %5$10.2f", id,nombre, apellido, fechaNacimiento,salario);
				System.out.println();
				
							
				
			}
			
			String insert = "INSERT INTO EMPLEADOS (NOMBRE,APELLIDO,FECHA_NACIMIENTO,SALARIO) values('Roberto','Martinez', DATE('1986-03-12'),1500.68)";
			if(st.executeUpdate(insert)!=1) {
				System.out.println("Error al insertar el registro");
			}
			
			
		}catch(SQLException e) {
			System.out.println("SQL EXCEPTION: "+ e);
		}

	}

}
