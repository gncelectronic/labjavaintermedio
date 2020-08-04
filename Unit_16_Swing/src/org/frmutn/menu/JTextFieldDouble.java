package org.frmutn.menu;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class JTextFieldDouble extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected Document createDefaultModel() {
		// TODO Auto-generated method stub
		return new PlainDocumentDouble();
	}
	
	protected class PlainDocumentDouble extends PlainDocument{

		@Override
		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		
			//fuente: almacena el contenido de la caja de texto

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
			super.insertString(offs, new String(resultado,0,j), a);
		}
		
	}

}
