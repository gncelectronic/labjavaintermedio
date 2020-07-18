package org.frmutn.semaforo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Clase que implementa un semaforo, el cual es usado para controlar el acceso  a un recurso compartido, en constraste con un  simple bloque sincronizado, un  semaforo tiene un 
 * contador interno que es incrementado cada vez que un hilo adquiere un bloqueo y  es decrementado cada vez que un hilo libera un  bloqueo obtenido antes. Las operaciones de 
 * incremento y decremento son sincronizadas, asi un semaforo puede ser usado para  controlar cuantos hilos pasan simultaneamente atravez de una sección critica.
 * Las dos operaciones basicas de un hilo son:
 * 	void acquire();
 * 	void release();
 * 
 *  El constructor toma junto al número de bloqueos simultáneos un parámetro de equidad.
 *  
 *  El parámetro de equidad decide si los nuevos hilos, que tratan de adquirir un bloqueo, se establecen al principio o al final de la lista de hilos en espera.
 *  
 *   Poner el nuevo hilo al final de los hilos garantiza que todos los hilos adquirirán el bloquo después de algún tiempo y por lo tanto ningún hilo se muere de hambre o inanicion.
 *   
 *   Semaphore(int permits, boolean fair)
 *   
 *   Para ilustrar el comportamiento descrito, vamos a configurar un simple grupo de hilos con cinco hilos pero controlando a través de un semáforo en que cada punto en 
 *   el tiempo no más de tres de ellos están corriendo.
 *   
 *   Para asegurarnos de no tener mas de tres hilos concurrentes dentro de la sección critica, usamos un AtomicInteger que se incrementa cada vez 	que  un proceso ingresa en la sección y se 
 *   decrementa antes de salir de la sección. Cuando el contador tiene un valor  mayor que 4 , un IllegalSateException es lanzado. Finalmente  liberamos el semaforo y otro hilo espera para 
 *   ingresar a la sección critica.
 * @author Gaston
 *
 */
public class Semaforo implements Runnable {

	private static final Semaphore semaphore = new Semaphore(3, true);
	private static final AtomicInteger counter = new AtomicInteger();
	private static final long endMillis = System.currentTimeMillis() +10000;
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0; i<5 ;i++) {
			exec.execute(new Semaforo());
		}
		exec.shutdown();
	}
	
	@Override
	public void run() {
		while(System.currentTimeMillis() <endMillis) {
			try {
				semaphore.acquire();
				
			}catch(InterruptedException e) {
				System.out.println("["+Thread.currentThread().getName() +"]Interrupción en la adquisición");
			}
			
			int contador = counter.incrementAndGet();
			System.out.println("["+Thread.currentThread().getName()+"] Semaforo adquirido: "+ contador);
			
			if(contador >3) {
				throw new IllegalStateException("Mas de tres hilos han adquirido el semaforo.");
			}
			
			counter.decrementAndGet();
			semaphore.release();
		}

	}

}
