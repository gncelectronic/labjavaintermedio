package org.utnfrm.ejemplo;

import java.util.Random;

public class TareaImprimirRunnable implements Runnable {
	/*
	 * Tiempo de inactividad aleatorio para el hilo
	 */
	private final int tiempoInactividad;
	/**
	 * nombre de la tarea
	 */
	private final String nombreTarea;
	
	
	
	private final static Random generador = new Random();
	
	
	

	public TareaImprimirRunnable( String nombreTarea) {
		super();
		
		this.nombreTarea = nombreTarea;
		//elige un tiempo de inactividad aleatorio entre 0 y 5 segundos
		this.tiempoInactividad = generador.nextInt(5000);
	}



	/**
	 * El método run contiene el código que ejecutará el hilo.
	 */
	@Override
	public void run() {
		try {
			System.out.printf("%s va a estar inactivo durante %d milisegundos. \n", nombreTarea, tiempoInactividad);
			/**
			 * Deja el hilo inactivo
			 */
			Thread.sleep(tiempoInactividad);
		}catch(InterruptedException ex) {
			System.out.printf("%s %s \n", nombreTarea, "Terminno en forma prematura, debido a la interrupción.");
		}
		
		System.out.printf("%s termino su inactividad\n", nombreTarea);
		
	}

}
