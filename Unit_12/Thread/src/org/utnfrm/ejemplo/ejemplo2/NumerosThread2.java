package org.utnfrm.ejemplo.ejemplo2;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * Ejemplo del uso de hilos para que no se bloquee el boton de la IU.
 * @author Gaston Cangemi
 *
 */
public class NumerosThread2 extends JFrame   implements ActionListener, Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static boolean go = true;
	JButton botonStart;
	JButton botonStop;
	
		

	public NumerosThread2() throws HeadlessException {
		super();
		setLayout(null);
		this.botonStart =  new JButton("Start");
		this.botonStop =new JButton("Stop");
		botonStart.setBounds(50, 100, 100, 40);
		botonStop.setBounds(160,100, 100, 40);
		add(botonStart);
		botonStart.addActionListener(this);
		add(botonStop);
		botonStop.addActionListener(this);
		setTitle("Numeros con hilos");
	}


	public static void main(String[] args) {
		NumerosThread2 nt= new NumerosThread2();
		nt.setBounds(0, 0, 500, 500);
		nt.setVisible(true);

		
		
	
	}

	/**
	 * Captura el eventio clic de  los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==botonStart) {
			Thread t = new Thread(this);
			t.start();
			
			/*
			 * Creo un bloque runneable para poder crear un nuevo hilo con otra funcionalidad
			 */
			Runnable r = new Runnable() {
				
				@Override
				public void run() {
					go = true;
					int count=0;
					while(go) {
						//Imprimimos caracteres de la A - J
						System.out.print((char) (65+count));
						
						count++;
						if(count >9) {
							count=0;
							System.out.println();
						}
					}
					
				}
				
			};
		Thread t2 = new Thread(r);
		t2.start();    
	
		}
		
		if(e.getSource()== botonStop) {
			go = false;
		}
		
	}


	@Override
	public void run() {
		go = true;
		int count=0;
		while(go) {
			System.out.print(count);
			
			count++;
			if(count >9) {
				count=0;
				System.out.println();
			}
		}
		
	}

	

	
}
