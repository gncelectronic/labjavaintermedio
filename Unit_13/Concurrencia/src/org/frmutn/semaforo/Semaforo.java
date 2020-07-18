package org.frmutn.semaforo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Clase que implementa un semaforo, el cual es usado para controlar el acceso  a un recurso compartido, en constraste con un  simple bloque sincronizado, un  semaforo tiene un 
 * contador interno que es incrementado cada vez que un hilo adquiere un bloqueo y  es decrementado cada vez que un hilo libera un  bloqueo obtenido antes. Las operaciones de 
 * incremento y decremento son sincronizadas, asi un semaforo puede ser usado para  controlar cuantos hilos pasan simultaneamente atravez de una secci�n critica.
 * Las dos operaciones basicas de un hilo son:
 * 	void acquire();
 * 	void release();
 * 
 *  El constructor toma junto al n�mero de bloqueos simult�neos un par�metro de equidad.
 *  
 *  El par�metro de equidad decide si los nuevos hilos, que tratan de adquirir un bloqueo, se establecen al principio o al final de la lista de hilos en espera.
 *  
 *   Poner el nuevo hilo al final de los hilos garantiza que todos los hilos adquirir�n el bloquo despu�s de alg�n tiempo y por lo tanto ning�n hilo se muere de hambre o inanicion.
 *   
 *   Semaphore(int permits, boolean fair)
 *   
 *   Para ilustrar el comportamiento descrito, vamos a configurar un simple grupo de hilos con cinco hilos pero controlando a trav�s de un sem�foro en que cada punto en 
 *   el tiempo no m�s de tres de ellos est�n corriendo.
 *   
 *   Para asegurarnos de no tener mas de tres hilos concurrentes dentro de la secci�n critica, usamos un AtomicInteger que se incrementa cada vez 	que  un proceso ingresa en la secci�n y se 
 *   decrementa antes de salir de la secci�n. Cuando el contador tiene un valor  mayor que 4 , un IllegalSateException es lanzado. Finalmente  liberamos el semaforo y otro hilo espera para 
 *   ingresar a la secci�n critica.
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
				System.out.println("["+Thread.currentThread().getName() +"]Interrupci�n en la adquisici�n");
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
