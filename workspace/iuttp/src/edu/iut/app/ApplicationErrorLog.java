package edu.iut.app;
import java.util.logging.Logger;
public class ApplicationErrorLog extends AbstractApplicationLog {

	public ApplicationErrorLog() {
		super();
		 protected Logger log=Logger.getLogger(this.getClass().getName());
			logger.setLevel(Level.INFO);
			logger.info("[ERROR]"); 
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
		ApplicationSession.instance().getGUILogger().severe(this.message);
		super.fireMessage("[ERROR]", this.message);
		
	}


}
