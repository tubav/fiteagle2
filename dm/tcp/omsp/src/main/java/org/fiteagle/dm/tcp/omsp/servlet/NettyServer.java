package org.fiteagle.dm.tcp.omsp.servlet;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class NettyServer {

	private ServerBootstrap bootstrap;
	private Channel channel;
	private NioServerSocketChannelFactory factory;

	public void endServer() {
		System.out.println("Shutting down...");

		this.channel.close().awaitUninterruptibly(2000);
		this.channel.getCloseFuture().awaitUninterruptibly(2000);

		this.bootstrap.releaseExternalResources();
		this.bootstrap.shutdown();

		this.factory.releaseExternalResources();
		this.factory.shutdown();
	}

	public void startServer() {
		this.factory = new NioServerSocketChannelFactory(
				Executors.newCachedThreadPool(),
				Executors.newCachedThreadPool());

		this.bootstrap = new ServerBootstrap(this.factory);

		this.bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
			@Override
			public ChannelPipeline getPipeline() {
				return Channels.pipeline(new EchoServerHandler());
			}
		});

		this.bootstrap.setOption("child.tcpNoDelay", true);
		this.bootstrap.setOption("child.keepAlive", true);

		this.channel = this.bootstrap.bind(new InetSocketAddress(8888));
		System.out.println("Server Started!");

	}
}