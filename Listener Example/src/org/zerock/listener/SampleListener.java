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
    
    // �� WebApplication�� �������ٸ�
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("downed.....");
    	System.out.println("downed.....");
    	System.out.println("downed.....");
    	System.out.println("downed.....");

    }

    // �� WebApplication�� ��ٸ�
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("start.....");
    	System.out.println("start.....");
    	System.out.println("start.....");
    	System.out.println("start.....");

    }
	
}
