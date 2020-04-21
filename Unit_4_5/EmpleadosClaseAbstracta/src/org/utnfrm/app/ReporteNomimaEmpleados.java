package org.utnfrm.app;

import org.utnfrm.entidades.Empleado;
import org.utnfrm.entidades.EmpleadoAsalariado;
import org.utnfrm.entidades.EmpleadoBaseMasComision;
import org.utnfrm.entidades.EmpleadoPorComsion;
import org.utnfrm.entidades.EmpleadoPorHoras;

public class ReporteNomimaEmpleados {

	public static void main(String[] args) {
		EmpleadoAsalariado empAsalariado = new EmpleadoAsalariado(12345, "Enrique", "Vazquez", "123-456-789", 80000);
		EmpleadoPorHoras empHoras = new EmpleadoPorHoras(5678, "Roberto", "Fuentes", "345-456-222", 450, 45);
		EmpleadoPorComsion empComision = new EmpleadoPorComsion(333, "Valeria", "Ortiz", "333-555-777", 600, 15.7);
		EmpleadoBaseMasComision empBaseComision= new EmpleadoBaseMasComision(334, "Julio", "Valles", "345-777-444", 400, 15.70, 30000);
		
		System.out.printf("%n%s%n%s: $%,.2f%n%n", empAsalariado, "ingresos",empAsalariado.calcularSalario());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", empHoras, "ingresos",empHoras.calcularSalario());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", empComision, "ingresos",empComision.calcularSalario());
		System.out.printf("%n%s%n%s: $%,.2f%n%n", empBaseComision, "ingresos",empBaseComision.calcularSalario());
		
		Empleado[] empleados = new Empleado[4];
		empleados[0]=empAsalariado;
		empleados[1]= empHoras;
		empleados[2]= empComision;
		empleados[3]= empBaseComision;
		
		System.out.println("Empledos procesados en forma polimorfica:%n%n");
		for(Empleado empleadoActual : empleados) {
			if(empleadoActual instanceof EmpleadoBaseMasComision) {
				EmpleadoBaseMasComision empTemp = (EmpleadoBaseMasComision) empleadoActual;
				empTemp.setSalarioBase(empTemp.getSalarioBase()* 1.10);
				System.out.printf("El nuevo salario con 10%% de aumento es: $%,.2f%n", empTemp.getSalarioBase());
			}
			System.out.printf("%n%s%n%s: $%,.2f%n%n", empleadoActual, "ingresos",empleadoActual.calcularSalario());
			//System.out.printf("Ingresos $%,.2f%n%n", empleadoActual.calcularSalario());
		}
				


	}

}
