package edu.iut.exceptions;
import java.util.logging.Logger;

// Exercice 2 
public class IUTException /* étendre les exceptio, */{
	protected Logger logger;
	public IUTException() {
		super();
		 protected Logger log=Logger.getLogger(this.getClass().getName());
		logger.setLevel(Level.INFO);
		// Logger une erreur avec le message empty en utilisant le singleton session, ie le logger défini dans la session */

	}
	public IUTException(IUTException e) {
		super ();
		protected Logger log=Logger.getLogger(this.getClass().getName());
		logger.setLevel(Level.INFO);
		// Logger une erreur avec le message contenu dans 'e'  en utilisant le singleton session, ie le logger défini dans la session */
	}
	public IUTException(String message) {
		super();
		protected Logger log=Logger.getLogger(message);
		logger.setLevel(Level.INFO);
		// Logger une erreur avec le message contenu dans 'message'  en utilisant le singleton session, ie le logger défini dans la session */
	}
	
}
