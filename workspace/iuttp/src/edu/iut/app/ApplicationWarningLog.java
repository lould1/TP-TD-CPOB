package edu.iut.app;
import java.util.logging.Logger;
public class ApplicationWarningLog extends AbstractApplicationLog {

	public ApplicationWarningLog() {
		super();
		protected Logger log=Logger.getLogger(this.getClass().getName());
		logger.setLevel(Level.INFO);
		logger.info("[WARNING]"); 
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
		ApplicationSession.instance().getGUILogger().warning(this.message);
		super.fireMessage("[WARNING]", this.message);
	}
}
