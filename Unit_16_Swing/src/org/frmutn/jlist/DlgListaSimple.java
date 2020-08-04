package org.frmutn.jlist;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class DlgListaSimple extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane jScrollPanel;
	private JComboBox<String> listaTipoEmpleados;
	private JButton jbtAceptar;

	public DlgListaSimple(Frame arg0,  boolean arg2) {
		super(arg0, arg2);
		initsComponents();
		
		setSize(300,200);
	}

	private void initsComponents() {
		String tipos[] = {"Asalariado", "Por Horas", "Por Comisión", "Base mas Comision"};
		listaTipoEmpleados = new JComboBox<String>(tipos);
		jbtAceptar = new JButton();
		getContentPane().setLayout(null);
		setTitle("Lista de Tipos de Empleados");
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				formWindowClosing(e);
			}
		});
		
		jbtAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jbtAceptarActionPerformed(e);
				
			}
		});
		
		getContentPane().add(listaTipoEmpleados);
		listaTipoEmpleados.setBounds(15, 20, 165, 24);
		jbtAceptar.setMnemonic('A');
		jbtAceptar.setText("Aceptar");
		getContentPane().add(jbtAceptar);
		jbtAceptar.setBounds(210, 20, 79, 26);
		
		
	}

	protected void formWindowClosing(WindowEvent e) {
		setVisible(false);
		dispose();
		
	}
	
	
	private void jbtAceptarActionPerformed(ActionEvent e) {
		Object elementoSeleccionado;
		elementoSeleccionado= listaTipoEmpleados.getSelectedItem();
		JOptionPane.showMessageDialog(null, elementoSeleccionado);
	}
	
	
	

}
