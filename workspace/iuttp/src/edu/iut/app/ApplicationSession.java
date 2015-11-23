package edu.iut.app;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.*;

public class ApplicationSession extends TestCase{
	
	// Exercice 1 : G茅rer l'internationation
	protected /* Objet permettant la gestion des 'resources bundle' */ResourceBundle resourceBundle;
	protected Locale locale;
	
	// Exercice 2 : Logger
	protected Logger sessionGuiLogger;
	protected Logger sessionExceptionLogger;


	private static /*Qu'est ce qu'un singleton ?*/ ApplicationSession session = null;
	private ApplicationSession() {
		/* Definir US comme locale par d茅faut */
		Locale.setDefault(locale.US);/* �� compl茅ter */
		
		locale = Locale.getDefault();
		//resourceBundle = new ApplicationSession();/* �� compl茅ter */
		ResourceBundle resourceBundle = ResourceBundle.getBundle("edu.iut.res.ExampleResourceBundle"); 
		
		sessionGuiLogger.setLevel(Level.ALL);
		sessionExceptionLogger = sessionGuiLogger.getLogger(Logger.GLOBAL_LOGGER_NAME); /* Logger pour exception */;
		sessionExceptionLogger.setLevel(Level.ALL);
	}
	
	
	static public ApplicationSession instance() {
		if (session == null) {			
			session = new ApplicationSession();
		}
		return session;
	}
	
	public Logger getGUILogger() {
		return sessionGuiLogger;
	}
	public Logger getExceptionLogger() {
		return sessionExceptionLogger;
	}
	
	public void setLocale(Locale locale){
		this.locale = locale;
		Locale.setDefault(this.locale);
		//resourceBundle=/* r茅cup茅rer les resources */
	resourceBundle = ResourceBundle.getBundle("edu.iut.res.ExampleResourceBundle"); 
	}
	
	public String getString(String key) {
		return resourceBundle.getString(key);
	}
	
	
}
