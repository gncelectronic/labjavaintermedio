package org.utnfrm.exc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.utnfrm.exc.model.Empleado;

public class EmpleadoDAOMemoryImpl implements EmpleadoDAO {
	
	private HashMap<Integer, Empleado> empleados = new HashMap<>();

	@Override
	public void close() throws Exception {
		  System.out.println("No database connection to close just yet");
		
	}

	@Override
	public void add(Empleado emp) throws DAOException {
		if(empleados.get(emp.getId())!=null) {
			throw new DAOException("Error al agregar empleado, el mismo ya existe " + emp.getId());
		}
		try {
			empleados.put(emp.getId(), emp);
		}catch(Exception e) {
			throw new DAOException("Error al agregar empleado "+ e.getMessage());
		}
		
	}

	@Override
	public void update(Empleado emp) throws DAOException {
		if(empleados.get(emp.getId())==null) {
			throw new DAOException("Error al actualizar empleado, el mismo ya existe " + emp.getId());
		}
		try {
			empleados.put(emp.getId(), emp);
		
		}catch(Exception e) {
			throw new DAOException("Error al actualizar empleado "+ e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) throws DAOException {
	if(empleados.get(id)==null) {
		throw new DAOException("Error no existe el empleado con id: " + id);
	}
	try {
		empleados.remove(id);
		
	}catch(Exception e) {
		throw new DAOException("Error al eliminar empleado "+ e.getMessage());
	}
		
	}

	@Override
	public Empleado findById(int id) throws DAOException {
	try {
		return empleados.get(id);
	}catch(Exception e) {
		throw new DAOException("Error al buscar empleado "+ e.getMessage());
	}
	}

	@Override
	public Empleado[] getAllEmpleados() throws DAOException {
		List<Empleado> listaEmp = new ArrayList<>();
		for(Integer key: empleados.keySet()) {
			listaEmp.add(empleados.get(key));
		}
		
		return listaEmp.toArray(new Empleado[0]);
	}

}
