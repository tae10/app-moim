package config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Appinitializer implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
	
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   System.out.println("[SERVER] ojdbc library load success");
			
			
		}catch(Exception e) {
			
			  e.printStackTrace();
			  System.out.println("[SERVER] ojdbc library load failed");
			  System.exit(0);
		}
		
		
		
		
		
		
	}
	
	
	
}
