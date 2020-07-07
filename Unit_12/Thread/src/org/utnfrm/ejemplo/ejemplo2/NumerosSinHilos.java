package org.utnfrm.ejemplo.ejemplo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javafx.application.Application;
import javafx.stage.Stage;

public class NumerosSinHilos {
	static boolean go = true;

	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		
		JButton botonStart = new JButton("Start");
		JButton botonStop = new JButton("Stop");
		
		botonStart.setBounds(50, 100, 100, 40);
		botonStop.setBounds(160,100, 100, 40);
		f.add(botonStart);
		f.add(botonStop);
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
	
		
		botonStart.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});

		botonStop.addActionListener(new ActionListener(
				) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				go=false;
				
			}
		});
		
	}

	

	
}
