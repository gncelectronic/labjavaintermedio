package org.frmutn;


import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleTest {
	
	static void mostrarValor(Locale currentLocale, String key) {

		
		ResourceBundle titulo = ResourceBundle.getBundle("org.frmutn.menu",currentLocale);
		String valor = titulo.getString(key);
	
			System.out.println("Locale= "+ currentLocale.toString()+", "+
	                " Key= "+key +", "+
			           "value= " + valor);
			
				
			
		
	
		
	}
	
	static void mostrarFecha(Locale currentLocale, Date date) {
		DateFormat df =DateFormat.getDateInstance(DateFormat.DEFAULT, currentLocale);
		System.out.println(df.format(date)+", "+ currentLocale.toString());
	}
	
	static void  mostrarMoneda(Locale currentLocale, double monto) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(currentLocale);
		System.out.println(nf.format(monto)+" "+ currentLocale.toString());
	}

	public static void main(String[] args) {
		//L10N -> Localization
		//I18N -> Internationalization
		
		//Locale
		// ResourceBundle -> java.util.*
		
		
		Locale[] supportedLocales= {
				Locale.US,
				Locale.GERMANY,
				Locale.FRANCE,
				new Locale("ru","RU"),
				Locale.SIMPLIFIED_CHINESE,
				Locale.getDefault()
		};
		
		for(int i=0 ; i< supportedLocales.length;i++) {
			System.out.println();
			mostrarValor(supportedLocales[i], "alta");
			mostrarValor(supportedLocales[i], "modificar");
			mostrarValor(supportedLocales[i], "baja");
			mostrarFecha(supportedLocales[i], new Date());
			mostrarMoneda(supportedLocales[i], 589.3);
			
			
			
		}
		


	}

}
