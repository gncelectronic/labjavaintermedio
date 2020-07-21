package org.frmutn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.frmutn.entidades.Empleado;
/**
 *  VERIFICAR DE CREAR LA BASE DE DATOS 
 *  connect 'jdbc:derby://localhost:1527/empleadosdb2;create=true';
 *  
 *  CREATE TABLE EMPLEADOS ( LEGAJO INTEGER, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL ,FECHA_NACIMIENTO DATE, SALARIO FLOAT, PRIMARY KEY(LEGAJO));
 * @author Gaston
 *
 */
public class EmpleadoDAOJDBCImpl implements EmpleadoDAO {
	
	private Connection con = null;
	
	

	public EmpleadoDAOJDBCImpl() {
		super();
		String url = "jdbc:derby://localhost:1527/empleadosdb2";
		String username="";
		String password="";
		
		try {
			con= DriverManager.getConnection(url);
		}catch(SQLException e) {
			System.out.println("Error al intentar conectarse con la base de datos.");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@Override
	public void crear(Empleado empleado) throws DAOException{
		try(Statement st = con.createStatement()){
			String query ="INSERT INTO EMPLEADOS VALUES ("+ empleado.getLegajo() +","
					+"'"+ empleado.getNombre() + "'," +"'"+ empleado.getApellido() +"',"
					+"'"+ new java.sql.Date(empleado.getFechaNac().getTime())+ "'," + empleado.getSalario()+ ")";
			if(st.executeUpdate(query)!=1) {
				throw new DAOException("Error al agregar empleado.");
			}
					
		}catch(SQLException ex) {
			throw new DAOException("Error al insertar un empleado",ex);
		}

	}

	@Override
	public void actualizar(Empleado empleado) throws DAOException{
		try(Statement st = con.createStatement()){
			String query ="UPDATE  EMPLEADOS  SET NOMBRE ='"+ empleado.getNombre() +"',"
					       +" APELLIDO='"+ empleado.getApellido() +"',"
					       +" FECHA_NACIMIENTO='"+ new java.sql.Date(empleado.getFechaNac().getTime())+ "'," 
					       +" SALARIO =" + empleado.getSalario()
					       +" WHERE LEGAJO ="+ empleado.getLegajo();
		
			if(st.executeUpdate(query)!=1) {
				throw new  DAOException("Error al actualizar empleado");
			}
			
		}catch(SQLException ex) {
			throw new DAOException("Error al actualizar  empleado",ex);
		}

	}

	@Override
	public void eliminar(long legajo)throws DAOException {
		Empleado emp = findById(legajo);
		if(emp == null) {
			throw new DAOException("Empleado con legajo: "+ legajo +" no existe para borrar." );
		}
		
		try(Statement st = con.createStatement()){
			String query = "DELETE FROM EMPLEADOS WHERE LEGAJO ="+ legajo;
			if(st.executeUpdate(query)!=1) {
				throw new DAOException("Error al borrar el empleado");
			}
		}catch(SQLException e) {
			throw new DAOException("Error al borrar empleado en DAO",e);
		}

	}

	@Override
	public Empleado findById(long legajo)throws DAOException {
	try(Statement st = con.createStatement()){
		String query ="SELECT * FROM EMPLEADOS WHERE LEGAJO="+legajo;
		ResultSet rs = st.executeQuery(query);
		if(!rs.next()) {
			return null;
		}
		return (new Empleado(rs.getLong("LEGAJO"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getDate("FECHA_NACIMIENTO"),rs.getFloat("SALARIO")));
	}catch(SQLException e) {
		throw new DAOException("Error al buscar empleado en DAO", e);
	}
	}

	@Override
	public Empleado[] getTodosEmpleados() throws DAOException{
		try(Statement st = con.createStatement()){
			String query ="SELECT * FROM EMPLEADOS";
			ResultSet rs = st.executeQuery(query);
			ArrayList<Empleado> empleados = new ArrayList<>();
			while(rs.next()) {
				empleados.add(new Empleado(rs.getLong("LEGAJO"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getDate("FECHA_NACIMIENTO"),rs.getFloat("SALARIO")));
				
			}
			return empleados.toArray(new Empleado[0]);
		}catch(SQLException e) {
			throw new DAOException("Error al buscar todos los empleados",e);
		}
		
	}

}
