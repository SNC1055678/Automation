package testDemo;



import org.apache.log4j.BasicConfigurator;  
	import org.apache.log4j.LogManager;  
	import org.apache.log4j.Logger;  
	   
	public class Log4j {  
	   
	  private static final Logger logger = LogManager.getLogger(Log4j.class);  
	 public static void main(String[] args) {  
	  // basic log4j configurator  
	  BasicConfigurator.configure();  
	  logger.info("Hello world");  
	  logger.info("we are in logger info mode");  
	   
	 }  
	   
	}  