package org.utnfrm.ejemplo;

public class CreadorHilos {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Debe ingresar un argumento run o thread");
			System.exit(0);
		}

		Thread hilo1 = null;
		Thread hilo2 = null;
		Thread hilo3 = null;
		Thread hilo4 = null;

		if (args[0].equals("run")) {
			System.out.println("Creando hilos implementando Interfaz Runnable.");
			hilo1 = new Thread(new TareaImprimirRunnable("Tarea1"));
			hilo2 = new Thread(new TareaImprimirRunnable("Tarea2"));
			hilo3 = new Thread(new TareaImprimirRunnable("Tarea3"));
			hilo4 = new Thread(new TareaImprimirRunnable("Tarea4"));

		}

		else if (args[0].equals("thread")) {
			System.out.println("Creando hilos extendiendo de la clase Thread.");
			hilo1 = new TareaImprimirThread("Tarea1");
			hilo2 = new TareaImprimirThread("Tarea2");
			hilo3 = new TareaImprimirThread("Tarea3");
			hilo4 = new TareaImprimirThread("Tarea4");

		}
		System.out.println("Hilos creados, iniciando tareas.");

		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();

		System.out.println("Tareas Iniciadas, main termina.");
	}

}
