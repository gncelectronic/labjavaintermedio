package org.frmutn.test;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.frmutn.dao.DAOException;
import org.frmutn.dao.EmpleadoDAO;
import org.frmutn.dao.EmpleadoDAOFactory;
import org.frmutn.entidades.Empleado;


/**
 * Clase ejecutable de empleadoDAO
 * @author Gaston
 *
 */
public class EmpleadoDAOApp {

	public static void main(String[] args) throws DAOException {
		EmpleadoDAO empDAO = EmpleadoDAOFactory.crearEmpleadoDAO();
		Empleado emp = null;

		Scanner keyboard = new Scanner(System.in);
		String input = "";
		do {
			try {
				System.out.println("Ingrese un opción con la primera letra de la palabra");
				System.out.println("\n\n [C]rear | [A]ctualizar| [B]orrar| [L]istar | [S]alir: ");
				input = keyboard.nextLine();
				switch (input.charAt(0)) {
				case 'C':

					emp = inputEmployee(keyboard);
					empDAO.crear(emp);
					System.out.println("Se creo el empleado: " + emp.getLegajo());
					System.out.println("\n\nCreado " + emp);
					break;

				case 'A':
					System.out.println("Ingrese un legajo del empleado a actualizar: ");
					long legajo = Long.parseLong(keyboard.nextLine());
					emp = empDAO.findById(legajo);
					if (emp == null) {
						System.out.println("\n\nEmpleado " + legajo + " no encontrado");
						break;
					}

					emp = inputEmployee(keyboard, emp);
					empDAO.actualizar(emp);
					System.out.println("Empleado actualizado: " + emp.getLegajo());
					break;

				case 'B':
					System.out.println("Ingrese el legajo del empleado a borrar: ");
					legajo = new Long(keyboard.nextLine());

					emp = empDAO.findById(legajo);
					if (emp != null) {
						
						System.out.println(emp + "\n");
						empDAO.eliminar(legajo);
						System.out.println("Empleado eliminado");
					} else {
						System.out.println("\n\nEmplead " + legajo + " not encontrado");
						break;
					}

					break;

				case 'L':
					Empleado[] lista = empDAO.getTodosEmpleados();
					for (Empleado empleado : lista) {
						System.out.println(empleado + "\n");
					}
					break;

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (!input.startsWith("S"));

	}

	public static Empleado inputEmployee(Scanner in) throws IOException {
		return inputEmployee(in, null, true);
	}

	public static Empleado inputEmployee(Scanner in, Empleado empleado) throws IOException {
		return inputEmployee(in, empleado, false);
	}

	public static Empleado inputEmployee(Scanner in, Empleado empleado, boolean newEmpleado) throws IOException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		long id = -1;
		String nombre;
		String apellido;
		Date fechaNac = null;
		Empleado emp;
		float salario;

		if (newEmpleado) {
			do {
				System.out.println("Ingrese un valor entero para el legajo: ");
				try {
					id = new Long(in.nextLine());
					if (id < 0) {
						System.out.println(" Por favor intente de nuevo con un valor positivo para el legajo:");
					}
				} catch (NumberFormatException e) {
					System.out.println("Por favor repita con un valor positivo valido: ");
				}
			} while (id < 0);
		} else {
			id = empleado.getLegajo();
			System.out
					.println("Modifique los campos del empleado con legajo : " + id + ". Presione enter para aceptar el valor actual.");
		}

		String prompt = "Ingrese un valor para el nombre: "
				+ ((empleado == null) ? "" : " [" + empleado.getNombre() + "]");

		do {
			System.out.println(prompt + " : ");
			nombre = in.nextLine();
			if (nombre.equals("") && empleado != null) {
				nombre = empleado.getNombre();
			}
			if (nombre.length() < 1) {
				System.out.println(" Por favor reintente con un  valor valido para el nombre");
			}
		} while (nombre.length() < 1);

		prompt = "Ingrese un valor para el apellido: "
				+ ((empleado == null) ? "" : " [" + empleado.getApellido() + "]");
		do {
			System.out.println(prompt + " : ");
			apellido = in.nextLine();
			if (apellido.equals("") && empleado != null) {
				apellido = empleado.getApellido();
			}
			if (apellido.length() < 1) {
				System.out.println("Por favor reitente con un valor valido para el apellido");
			}
		} while (apellido.length() < 1);

		prompt = "Ingrese la fecha de Nacimiento (" + df.toLocalizedPattern() + ")"
				+ ((empleado == null) ? "" : " [" + df.format(empleado.getFechaNac()) + "]");
		do {
			System.out.println(prompt + " : ");
			String dateStr = in.nextLine();
			if (dateStr.equals("") && empleado != null) {
				fechaNac = empleado.getFechaNac();
			} else {
				fechaNac = null;
				try {
					fechaNac = new Date(df.parse(dateStr).getTime());
				} catch (ParseException e) {
					System.out.println("Por favor intente con una fecha valida: " + e.getMessage());
				}
			}
		} while (fechaNac == null);

		prompt = "Ingrese un salario para el empleado:"
				+ ((empleado == null) ? "" : " [" + nf.format((double) empleado.getSalario()) + "]");
		do {
			System.out.println(prompt + " : ");
			salario = 0;
			try {
				String amt = in.nextLine();
				if (!amt.equals("")) {
					salario = Float.parseFloat(amt);
				}
				if (salario == 0 && empleado != null) {
					salario = empleado.getSalario();
				}
				if (salario < 0) {
					System.out.println("Por favor reintente con un valor positivo para el salario");
					salario = 0;
				}
			} catch (NumberFormatException e) {
				System.out.println(" Por favor reintente con un valor decimal valido para el salario: " + e.getMessage());
			}
		} while (salario == 0);

		emp = new Empleado(id, nombre, apellido, fechaNac, salario);
		return emp;
	}

}
