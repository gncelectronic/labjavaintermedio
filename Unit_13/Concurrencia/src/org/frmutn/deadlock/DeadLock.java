package org.frmutn.deadlock;

import java.util.Random;

/**
 * DeadLock significa que dos (o más) hilos están cada uno esperando en el otro
 * hilo para liberar un recurso que ha bloqueado, mientras que el propio hilo ha
 * bloqueado un recurso que el otro hilo está esperando:
 * 
 * Thread 1: Locks resource A, waits for resource B Thread 2: Locks resource B,
 * waits for resource A
 * 
 * Si la variable b es true el resource1 es bloqueado primero y luego se bloquea
 * el resource 2 Si la variable b es false el resource2 es bloqueado primero por
 * el hilo y luego el resource 1
 * 
 * [thread-2] Recurso 2 bloqueado 
 * [thread-1] Recurso 1 bloqueado
 * [thread-2] Intentando bloqueaer el recurso 1 
 * [thread-1] Intentando bloquear el recurso 2
 * -> DEAD LOCK
 * 
 * @author Gaston
 *
 */
public class DeadLock implements Runnable {
	private static final Object resoruce1 = new Object();
	private static final Object resource2 = new Object();

	private final Random random = new Random(System.currentTimeMillis());

	public static void main(String[] args) {
		Thread thread1 = new Thread(new DeadLock(), "thread-1");
		Thread thread2 = new Thread(new DeadLock(), "thread-2");
		thread1.start();
		thread2.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			boolean b = random.nextBoolean();

			if (b) {
				System.out.println("[" + Thread.currentThread().getName() + "] Intentando bloqueaer el recurso 1");
				synchronized (resoruce1) {
					System.out.println("[" + Thread.currentThread().getName() + "] Recurso 1 bloqueado");

					System.out.println("[" + Thread.currentThread().getName() + "] Intentando bloquear el recurso 2");

					synchronized (resource2) {
						System.out.println("[" + Thread.currentThread().getName() + "] Recurso 2 bloqueado");
					}
				}
			} else {

				System.out.println("[" + Thread.currentThread().getName() + "] Intentando bloqueaer el recurso 2");
				synchronized (resource2) {

					System.out.println("[" + Thread.currentThread().getName() + "] Recurso 2 bloqueado");

					System.out.println("[" + Thread.currentThread().getName() + "] Intentando bloqueaer el recurso 1");

					synchronized (resoruce1) {
						System.out.println("[" + Thread.currentThread().getName() + "] Recurso 1 bloqueado");
					}
				}

			}

		}

	}

}
