package org.frmutn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConvertidorTemp extends JFrame {
	
	private JLabel jlbGradosC;
	private JLabel jlbGradosF;
	private JTextField jtfGradoC;
	private JTextField jtfGradoF;
	private JButton jbtAceptar;
	private Object objJtextField;
	
	public ConvertidorTemp() {
		setSize(300,200);
		setTitle("Conversion de temperaturas");
		initsComponents();
	}

	private void initsComponents() {
		getContentPane().setLayout(null);
		jlbGradosC = new JLabel();
		jlbGradosC.setText("Grados Centigrados");
		getContentPane().add(jlbGradosC);
		jlbGradosC.setBounds(12,28,116,24);
		
		jtfGradoC = new JTextField();
		jtfGradoC.setText("0,00");
		jtfGradoC.setHorizontalAlignment(JTextField.RIGHT);
		jtfGradoC.setBounds(132,28,144,24);
		getContentPane().add(jtfGradoC);
		
		//Etiqueta  parta los grados Fahrenheit
		jlbGradosF = new JLabel();
		jlbGradosF.setText("Grados Fahrenheit");
		getContentPane().add(jlbGradosF);
		jlbGradosF.setBounds(12, 68, 104, 24);
		
		
		//Caja de texto grado Fahrenheit
		jtfGradoF = new JTextField();
		jtfGradoF.setText("32.00");
		jtfGradoF.setHorizontalAlignment(JTextField.RIGHT);
		jtfGradoF.setBounds(132,72, 144, 24);
		getContentPane().add(jtfGradoF);
		
		jbtAceptar = new JButton();
		jbtAceptar.setText("Aceptar");
		jbtAceptar.setMnemonic('A');
		getRootPane().setDefaultButton(jbtAceptar);
		getContentPane().add(jbtAceptar);
		jbtAceptar.setBounds(132, 120, 144, 24);
		
		
		KeyListener kl = new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				jtfGradosKeyTyped(evt);
			}
			
			public void keyPressed(KeyEvent evt) {
				jtfGradosKeyPressed(evt);
			}
			
			public void keyReleased(KeyEvent evt) {
				jtfGradosKeyReleased(evt);
			}
		};
		
		jtfGradoC.addKeyListener(kl);
		jtfGradoF.addKeyListener(kl);
		
		jbtAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtAceptarActionPerformed(e);
				
			}
		});
		/**
		 * Creo un actionListener para interceptar la tecla enter de los textfield
		 */
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtAceptarActionPerformed(e);
				
			}
		};
		
		jtfGradoC.addActionListener(al);
		jtfGradoF.addActionListener(al);
		
		addWindowListener(new WindowAdapter() {
			public void windowsClosing(WindowEvent evt) {
				exitForm(evt);
			}
			
			public void windowOpened(WindowEvent evt) {
				formWindowOpened(evt);
			}
			
		}); 
		
		
		FocusAdapter fl = new FocusAdapter() {
			public void focusGained(FocusEvent evt) {
				jtfGradosFocusGained(evt);
			}
			
		};
		
		jtfGradoC.addFocusListener(fl);
		jtfGradoF.addFocusListener(fl);
		
	}
	

	

	/**
	 * Metodo quie atrapa el foco de un objeto
	 * @param evt
	 */
	protected void jtfGradosFocusGained(FocusEvent evt) {
		JTextField objEnfocado = (JTextField) evt.getSource();
		objEnfocado.selectAll();
		
	}

	protected void formWindowOpened(WindowEvent evt) {
		jtfGradoC.requestFocus();
		
		
	}
	/**
	 * Capturamos el evento de clic de boton
	 * @param e
	 */
	protected void jbtAceptarActionPerformed(ActionEvent e) {
		try {
			double grados;
			if(objJtextField == jtfGradoC) {
				grados = Double.parseDouble(jtfGradoC.getText())*9.0 /5.0 +32.0;
				String texto = String.format("%.2f", grados);
				jtfGradoF.setText(texto);
			}
			
			if(objJtextField == jtfGradoF) {
				grados = (Double.parseDouble(jtfGradoF.getText())-32)*5.0/9;
				String texto =String.format("%.2f", grados);
				jtfGradoC.setText(texto);
			}
		
		}catch(NumberFormatException ex){
			jtfGradoC.setText("0.00");
			jtfGradoF.setText("32.0");
		}
		
	}
	
	protected void jtfGradosKeyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		
	}

	protected void jtfGradosKeyTyped(KeyEvent evt) {

       objJtextField = evt.getSource(); //objeto que produjo el evento
		
	}
	

	
	
	protected void jtfGradosKeyReleased(KeyEvent evt) {
		//Obtener la caja de texto que generó el evento
		JTextField objJTF = (JTextField) evt.getSource();
		//fuente: almacena el contenido de la caja de texto
		String str = objJTF.getText();
		char[] fuente = str.toCharArray();
		//resultado: almacena el contenido de la caja de texto validado
		char[] resultado = new char[fuente.length];
		
		int j=0;
		boolean error = false;
		for(int i = 0; i<fuente.length; i++) {
			if(fuente[i] >='0' && fuente[i]<='9' || fuente[i]== '.'|| fuente[i]== '+'|| fuente[i]=='-')
				resultado[j++]=fuente[i];
			else {
				error =true;
				java.awt.Toolkit.getDefaultToolkit().beep();
			}
		}
		if(error) {
			objJTF.setText(new String(resultado,0,j));
		}
		
	}

	protected void exitForm(WindowEvent evt) {
		System.exit(0);
		
	}
	
	public static void main(String[] args) {
		new ConvertidorTemp().setVisible(true);;
	}

}

