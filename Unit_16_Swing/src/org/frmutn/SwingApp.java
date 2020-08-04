package org.frmutn;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SwingApp extends JFrame {
	
	private JLabel saludoLabel;
	private JButton jBtSaludo;
	

	public SwingApp() throws HeadlessException {
		super();
		setSize(300,200); //tamaño del formulario
		setTitle("Aplicación en Swing"); //Titulo del formulario
		initComponents();
	}



	private void initComponents() {
		getContentPane().setLayout(null);
		
		saludoLabel = new JLabel();
		
		saludoLabel.setText("etiqueta");
		saludoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saludoLabel.setFont(new Font("Dialog",1,18));
		getContentPane().add(saludoLabel);
		saludoLabel.setBounds(40,36,204,30);
		
		jBtSaludo = new JButton();
		jBtSaludo.setText("Hacer clic aquí");
		jBtSaludo.setToolTipText("Boton de Pulsación");
		jBtSaludo.setMnemonic('c');
		getContentPane().add(jBtSaludo);
		jBtSaludo.setBounds(40, 90, 204, 30);
		
		jBtSaludo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jBtSaludoActionPerformed(e);
				
			}
			
		});

		addWindowListener(new WindowAdapter() {
			public void windowsClosing(WindowEvent evt) {
				exitForm(evt);
			}
			
		}); 
		
	}



	protected void jBtSaludoActionPerformed(ActionEvent e) {
		float rojo = (float) Math.random();
		float verde = (float)Math.random();
		float azul = (float)Math.random();
		saludoLabel.setForeground(new Color(rojo,verde,azul));
		saludoLabel.setText("¡¡Hola Swing !!");
		
	}



	protected void exitForm(WindowEvent evt) {
		System.exit(0);
		
	}



	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("No es posible establecer el aspecto deseado: "+e);
		}
	
		new SwingApp().setVisible(true);
	}

}
