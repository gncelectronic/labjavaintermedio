package edu.utnfrm.bussines;

import edu.utnfrm.entidades.Director;
import edu.utnfrm.entidades.Empleado;
import edu.utnfrm.entidades.Gerente;
/**
 * Clase de negocio que permite calcular  diferentes propiedades de los empleados como las acciones
 * @author Gaston
 *
 */
public class EmpleadoAcciones {
	/**
	 * Metodo que obtiene la cantidad de acciones a comprar segun el tipo el tipo de empleado.
	 * @param e
	 * @return
	 */
	public int obtenerAcciones(Empleado e) {
		if (e instanceof Director) {
			return 10000;
		}
		if (e instanceof Gerente) {
			return 100;

		} else {
			return 10;
		}

	}

}
