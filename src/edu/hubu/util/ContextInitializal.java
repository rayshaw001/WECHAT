package edu.hubu.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextInitializal implements ServletContextListener{
	Map<Long, SendThread> sends;
	Thread it;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		sends = new HashMap<Long, SendThread>();
		arg0.getServletContext().setAttribute("sends", sends);
		it = new Thread(new InitialThread(sends));
		it.start();
		System.out.println("sends thread started");
	}
}
class InitialThread implements Runnable
{
	Map<Long, SendThread> sends;
	boolean flag = true;
	public InitialThread(Map<Long, SendThread> sends) {
		// TODO Auto-generated constructor stub
		this.sends = sends;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(808);
			while(true)
			{
				//初始化连接信息
				Socket socket =  ss.accept();
				InputStream is = socket.getInputStream();
				byte[] b = new byte[1024];
				is.read(b);
				Long id = Long.parseLong(new String(b).trim());
				//启动新的线程处理消息
				OutputStream os = socket.getOutputStream();
				SendThread st = new SendThread(id, os);
				Thread thread = new Thread(st);
				sends.put(id, st);
				thread.start();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}


