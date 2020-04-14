package edu.utnfrm.app;

import java.text.NumberFormat;
import java.util.Locale;

import edu.utnfrm.bussines.EmpleadoAcciones;
import edu.utnfrm.entidades.Director;
import edu.utnfrm.entidades.Empleado;
import edu.utnfrm.entidades.Gerente;
import edu.utnfrm.entidades.Ingeniero;

public class EmpleadoTest {
	
	public static void main(String[] args) {
		Ingeniero i = new Ingeniero(101,"Juan Perez",70_000.00, "0123-456-7899");
		Gerente g = new Gerente(207, "Valeria Olivares", 350_000.00, "6623-499-333", "RRHH");
		
		EmpleadoTest test = new EmpleadoTest();
		EmpleadoAcciones empAcc = new EmpleadoAcciones();
		//Imprimimos los datos originales de los empleados
		test.printEmpleado(i, empAcc);
		test.printEmpleado(g, empAcc);
//		//incrementamos salario del ingeniero
//		i.incrementarSalario(-5000);
//		//Cambiamos el nombre del Gerente
//		g.setNombre(null);
//		
//		//Imprimir valores modificados
//		test.printEmpleado(i);
//		test.printEmpleado(g);
		
	}
	
	/**
	 * Metodo para imprimir los datos de un empleado 
	 * @param e
	 */
	public void printEmpleado(Empleado e , EmpleadoAcciones empAcc) {
		
		System.out.printf("%s%s%n", "Tipo Empleado:",e.getClass().getSimpleName());
		System.out.printf("%s%s%n", "EmpID:",e.getEmpId());
		System.out.printf("%s%s%n", "Nombre:",e.getNombre());
		System.out.printf("%s%s%n", "SSN:",e.getSsn());
		System.out.printf("%s%f%n", "Salario:",e.getSalario());
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.printf("%s%s%n", "Salario:",nf.format(e.getSalario()));
		
		
		if(e instanceof Gerente) {
			Gerente g = (Gerente)e;
			System.out.printf("%s%s%n", "Dept:",g.getNombreDepartamento());
		}
		
		if(e instanceof Director) {
			Director d = (Director)e;
			System.out.printf("%s%f%n", "Dept:",d.getPresupuesto());
		}
		
		System.out.printf("%s%d%n", "Acciones:",empAcc.obtenerAcciones(e));
		
		System.out.printf("%s%n","--------------------------------");
		
		//System.out.println(e.toString()+", Cant. Acciones: "+ empAcc.obtenerAcciones(e));
	}

}
