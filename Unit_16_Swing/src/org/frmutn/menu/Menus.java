package org.frmutn.menu;

import java.awt.HeadlessException;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import org.frmutn.ConvertidorTempMVC;
import org.frmutn.jlist.DlgListaSimple;

import com.sun.org.apache.bcel.internal.generic.LMUL;

public class Menus extends JFrame {

	private JMenuBar jmbarBarraDeMenus;
	private JMenu jmnuArchivo;
	private JMenuItem jmItemAbrir;
	private JMenu jmnuGuardar;
	private JSeparator jSeparador1;
	private JMenuItem jmItemSalir;
	
	private JMenu jmnuEmpleado;
	private JMenuItem jmItemAltaEmpleado;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public Menus() throws HeadlessException {
		super();
		setSize(300,200);
		setTitle("Menus");
		initsComponents();
	}

	private void initsComponents() {
		/**
		 * 1) Creamos una barra de menús y la añadimos a la ventana de la clase Menus
		 * invocando al método setJMenuBar
		 */
		jmbarBarraDeMenus = new JMenuBar();
		setJMenuBar(jmbarBarraDeMenus);

		/**
		 * 2) Añadir los menús a la barra de menús
		 */
		jmnuArchivo = new JMenu();
		jmnuArchivo.setMnemonic('A');
		jmnuArchivo.setText("Archivo");
		jmbarBarraDeMenus.add(jmnuArchivo);
		
		/**
		 * 3) añadir al ménu los elementos que lo componen
		 * 
		 */
		jmItemAbrir = new JMenuItem();
		jmItemAbrir.setMnemonic('A');
		jmItemAbrir.setText("Abrir...");
		jmnuArchivo.add(jmItemAbrir);
		
		/**
		 *4)  Crear un submenu
		 */
		jmnuGuardar = new JMenu();
		jmnuGuardar.setMnemonic('G');
		jmnuGuardar.setText("Guardar");
		jmnuArchivo.add(jmnuGuardar);
		
		/**
		 * 5) Añadir un separador
		 */
		jSeparador1 = new JSeparator();
		jmnuArchivo.add(jSeparador1);
		
		
		/**
		 * Creamos un itemMenu para salir del sistema
		 */
		jmItemSalir = new JMenuItem();
		jmItemSalir.setMnemonic('S');
		jmItemSalir.setText("Salir...");
		jmnuArchivo.add(jmItemSalir);
		
		
		
		

		/**
		 * Este paso es para despues cuando se explique la lista simple  para llamar an jdialog
		 * 
		 * 
		 */
		jmnuEmpleado = new JMenu();
		jmnuEmpleado.setMnemonic('E');
		jmnuEmpleado.setText("ABM Empleados");
		jmbarBarraDeMenus.add(jmnuEmpleado);
		jmItemAltaEmpleado = new JMenuItem();
		jmItemAltaEmpleado.setText("Alta Empleados");
		jmnuEmpleado.add(jmItemAltaEmpleado);
		
		
		/**
		 * 6) Manejador de eventos
		 */
		jmItemSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jmItemSalirActionPerformed(e);
				
			}
		});
		
		/**
		 * 7) Crear un unico manejador de eventos para todas los menus
		 */
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object item = e.getSource();
				if(item == jmItemAbrir) {
					jmItemAbrirActionPerformed(e);
				}
				else if(item == jmItemSalir) {
					jmItemSalirActionPerformed(e);;
				}
				
				/**
				 * eso se agrega despues de explicar la listaSimple
				 * 
				 * 
				 */
				
				else if(item == jmItemAltaEmpleado) {
					jmItemAltaEmpleadoActionPerformed(e);
				}
			}
		};
		
		//asignar los manejadores de eventos  al a los elementos del menu Archivo
		jmItemAbrir.addActionListener(al);
		jmItemSalir.addActionListener(al);
		
		//agregar despues de explicar lista simple
		jmItemAltaEmpleado.addActionListener(al);
		
		
		
		
		
		
		/**
		 * Asigamos al contenedor JFrame un administrador de diseño null
		 */
		getContentPane().setLayout(null);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				exitForm(evt);
			}
		});
		
	}

	protected void jmItemAltaEmpleadoActionPerformed(ActionEvent e) {
		new DlgListaSimple(this, false).setVisible(true);
		
	}

	protected void jmItemAbrirActionPerformed(ActionEvent e) {
	    new ConvertidorTempMVC().setVisible(true);
		
	}

	protected void jmItemSalirActionPerformed(ActionEvent e) {
		System.exit(0);
	}

	protected void exitForm(WindowEvent evt) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[]args) {
		new Menus().setVisible(true);
	}

}
