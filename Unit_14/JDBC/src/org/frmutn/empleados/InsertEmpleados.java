package org.frmutn.empleados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Antes de correr este programa se debe haber creado la base de datos
 *  connect 'jdbc:derby://localhost:1527/empleadosdb;create=true';
 *  
 *   insert into empleados (NOMBRE,APELLIDO,FECHA_NACIMIENTO,SALARIO) values('Pedro','Robles', DATE('1978-06-24'),1500.68);
 * @author Gaston
 *
 */
public class InsertEmpleados {

	public static void main(String[] args) {
		String url= "jdbc:derby://localhost:1527/empleadosdb";
		String query= "INSERT INTO empleados (NOMBRE,APELLIDO,FECHA_NACIMIENTO,SALARIO) VALUES(?,?,?,?)";
		
		try(Connection con = DriverManager.getConnection(url);
				PreparedStatement ps = con.prepareStatement(query)){
				
				ps.setString(1, "Pedro");
				ps.setString(2, "Robles");
				Date fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse("1985-01-12");
				ps.setDate(3, new java.sql.Date(fechaNac.getTime()));
				ps.setDouble(4, 78000.85);
				
				int rta =ps.executeUpdate();
				if(rta ==1){
					System.out.println("Registro insertado");
				}
				
				
			
			
			
		}catch(SQLException e) {
			System.out.println("SQL EXCEPTION: "+ e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
