package edu.iut.app;
import java.util.logging.Logger;
public class ApplicationInfoLog extends AbstractApplicationLog {

	public ApplicationInfoLog() {
		super();
		protected Logger log=Logger.getLogger(this.getClass().getName());
		logger.setLevel(Level.INFO);
		logger.info("[INFO]"); 
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
		ApplicationSession.instance().getGUILogger().info(this.message);
        super.fireMessage("[INFO]", this.message);
	}

}
