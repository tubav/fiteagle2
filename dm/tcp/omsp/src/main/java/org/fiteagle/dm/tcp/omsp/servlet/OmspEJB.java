package org.fiteagle.dm.tcp.omsp.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OmspEJB implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("test");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("test");
		try {
			new NettyServer().startServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done");
	}
}
