package org.zerock.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


// Don't call me
// I'll call you
@WebListener
public class SampleListener implements ServletContextListener {

    public SampleListener() {
    	
    }
    
    // 이 WebApplication이 내려간다면
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("downed.....");
    	System.out.println("downed.....");
    	System.out.println("downed.....");
    	System.out.println("downed.....");

    }

    // 이 WebApplication이 뜬다면
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("start.....");
    	System.out.println("start.....");
    	System.out.println("start.....");
    	System.out.println("start.....");

    }
	
}
