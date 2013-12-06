package org.fiteagle.dm.tcp.omsp.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OmspServlet implements ServletContextListener {
	private NettyServer server;

	@Override
	public void contextDestroyed(final ServletContextEvent arg0) {
		System.out.println("Stopping OMSP...");
		this.server.endServer();
	}

	@Override
	public void contextInitialized(final ServletContextEvent arg0) {
		System.out.println("Starting OMSP...");
		try {
			this.server = new NettyServer();
			this.server.startServer();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
