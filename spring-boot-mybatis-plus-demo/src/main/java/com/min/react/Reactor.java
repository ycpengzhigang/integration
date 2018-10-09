package com.min.react;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.UUID;


public class Reactor implements Runnable {
	
	// 选择器
	final Selector selector;
	
	// 通道 
	final ServerSocketChannel serverSocket;
	
	Reactor(int port) throws IOException{
		// 获取选择器
		selector = Selector.open();
		serverSocket = ServerSocketChannel.open();
		// 绑定地址
		InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(),port);
		// 绑定一个地址
		serverSocket.socket().bind(address);
		// 设置为非阻塞 阻塞就是同步的意思 非阻塞就是异步的情况
		serverSocket.configureBlocking(false);
		// 向selector中注册该channel 并绑定接受事件
		SelectionKey skey = serverSocket.register(selector, SelectionKey.OP_ACCEPT);
		// 利用sk的attache功能绑定Acceptor 如果有事情，触发Acceptor
		// 
//		skey.attach(new Acceptor());
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}
	
	
	
	
	
	
	@Override
	public void run() {
		

	}

}
