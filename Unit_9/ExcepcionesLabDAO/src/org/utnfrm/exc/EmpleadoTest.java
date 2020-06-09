package org.utnfrm.exc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.utnfrm.exc.dao.DAOException;
import org.utnfrm.exc.dao.EmpleadoDAO;
import org.utnfrm.exc.dao.EmpleadoDAOFactory;
import org.utnfrm.exc.model.Empleado;

public class EmpleadoTest {
	
	public static void main(String[] args) {
		 boolean timeToQuit = false;
	try(EmpleadoDAO dao = EmpleadoDAOFactory.createEmpleadoDAO();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
		

		do {
			try {
				 timeToQuit = executeMenu(in, dao);
            } catch (DAOException e) {
                System.out.println("Error " + e.getClass().getName());
                System.out.println("Message: " + e.getMessage());
            }
		}while(!timeToQuit);
		
	} catch (IOException e) {
        System.out.println("Error " + e.getClass().getName() + " , quiting.");
        System.out.println("Message: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Error closing resource " + e.getClass().getName());
        System.out.println("Message: " + e.getMessage());
    }
	
	
	
			
			
	}

	private static boolean executeMenu(BufferedReader in, EmpleadoDAO dao) throws DAOException, IOException {
		Empleado emp;
        String action;
        int id;

        System.out.println("\n\n[C]reate | [R]ead | [U]pdate | [D]elete | [L]ist | [Q]uit: ");
        action = in.readLine();
        if ((action.length() == 0) || action.toUpperCase().charAt(0) == 'Q') {
            return true;
        }

        switch (action.toUpperCase().charAt(0)) {
            // Create a new employee record
            case 'C':
                emp = inputEmployee(in);
                dao.add(emp);
                System.out.println("Successfully added Employee Record: " + emp.getId());
                System.out.println("\n\nCreated " + emp);
                break;

            // Display an employee record
            case 'R':
                System.out.println("Ingrese un id: ");
                id = new Integer(in.readLine().trim());

                // Find this Employee record
                emp = dao.findById(id);
                if (emp != null) {
                    System.out.println(emp + "\n");
                } else {
                    System.out.println("\n\nEmployee " + id + " not found");
                    break;
                }

                break;

            // Update an existing employee record    
            case 'U':
                System.out.println("Ingrese un  id: ");
                id = new Integer(in.readLine().trim());
                // Find this Employee record
                emp = null;
                emp = dao.findById(id);
                if (emp == null) {
                    System.out.println("\n\nEmployee " + id + " not found");
                    break;
                }
                // Go through the record to allow changes

                emp = inputEmployee(in, emp);
                dao.update(emp);
                System.out.println("Successfully updated Employee Record: " + emp.getId());
                break;

            // Delete an employee record
            case 'D':
                System.out.println("Ingrese un id: ");
                id = new Integer(in.readLine().trim());

                // Find this Employee record                 
                dao.delete(id);
                System.out.println("Deleted Employee " + id);
                break;

            // Display a list (Read the records) of Employees
            case 'L':
                Empleado[] allEmps = dao.getAllEmpleados();
                for (Empleado employee : allEmps) {
                    System.out.println(employee + "\n");
                }
                break;
        }

        return false;
	}
	

    public static Empleado inputEmployee(BufferedReader in) throws IOException {
        return inputEmployee(in, null, true);
    }

    public static Empleado inputEmployee(BufferedReader in, Empleado empDefaults) throws IOException {
        return inputEmployee(in, empDefaults, false);
    }

    public static Empleado inputEmployee(BufferedReader in, Empleado empDefaults, boolean newEmployee) throws IOException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        int id = -1;
        String firstName;
        String lastName;
        Date birthDate = null;
        Empleado emp;
        float salary;

        if (newEmployee) {
            do {
                System.out.println("Ingrese un id para el empleado: ");
                try {
                    id = new Integer(in.readLine().trim());
                    if (id < 0) {
                        System.out.println("Por favor ingrese un valor positivo para el id");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor ingrese un valor entero para el id");
                }
            } while (id < 0);
        } else {
            id = empDefaults.getId();
            System.out.println("Modificando los campos del empleado: " + id
                    + ". Presione enter para aceptar los valores actuales.");
        }

        String prompt = "Ingrese un valor para el Nombre" + ((empDefaults == null) ? "" : " [" + empDefaults.getNombre() + "]");

        do {
            System.out.println(prompt + " : ");
            firstName = in.readLine().trim();
            if (firstName.equals("") && empDefaults != null) {
                firstName = empDefaults.getNombre();
            }
            if (firstName.length() < 1) {
                System.out.println("Por favor ingrese un valor valido para el nombre");
            }
        } while (firstName.length() < 1);


        prompt = "Ingrese apellido" + ((empDefaults == null) ? "" : " [" + empDefaults.getApellido() + "]");
        do {
            System.out.println(prompt + " : ");
            lastName = in.readLine().trim();
            if (lastName.equals("") && empDefaults != null) {
                lastName = empDefaults.getApellido();
            }
            if (lastName.length() < 1) {
                System.out.println("Por favor ingrese un valor valido para el apellido");
            }
        } while (lastName.length() < 1);


        prompt = "Ingrese fecha de Nacimiento (" + df.toLocalizedPattern() + ")"
                + ((empDefaults == null) ? "" : " [" + df.format(empDefaults.getFechaNac()) + "]");
        do {
            System.out.println(prompt + " : ");
            String dateStr = in.readLine().trim();
            if (dateStr.equals("") && empDefaults != null) {
                birthDate = empDefaults.getFechaNac();
            } else {
                birthDate = null;
                try {
                    birthDate = new Date(df.parse(dateStr).getTime());
                } catch (ParseException e) {
                    System.out.println("Por favor ingrese un valor valid para la fecha de nacimiento: " + e.getMessage());
                }
            }
        } while (birthDate == null);


        prompt = "Ingrese salario"
                + ((empDefaults == null) ? "" : " [" + nf.format((double) empDefaults.getSalario()) + "]");
        do {
            System.out.println(prompt + " : ");
            salary = 0;
            try {
                String amt = in.readLine().trim();
                if (!amt.equals("")) {
                    salary = Float.parseFloat(amt);
                }
                if (salary == 0 && empDefaults != null) {
                    salary = empDefaults.getSalario();
                }
                if (salary < 0) {
                    System.out.println("Por favor ingrese un valor positivo para el salario");
                    salary = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un valor valido para el salario: " + e.getMessage());
            }
        } while (salary == 0);

        // Create an Employee object
        emp = new Empleado(id, firstName, lastName, birthDate, salary);
        return emp;
    }
	

}
