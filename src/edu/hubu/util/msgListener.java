package edu.hubu.util;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/*
 * Author @Ray
 * Setting Initialize Intercepter
 * 配置初始化之后要做的事情 
 * something must be done after spring mvc is set！！！
 * especially annotation 
 * this place is for database initialization
 */


public class msgListener extends HandlerInterceptorAdapter implements 
InitializingBean{

	String msg = "hello rayshaw ,you're ok"; 
	InetAddress ia = null;
	int i = 0;
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("first begin");
		// TODO Auto-generated method stub
		/*Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				byte [] rec = new byte [1024];
				try{
					ia = InetAddress.getByName("192.168.1.130");
					DatagramSocket ds = new DatagramSocket(5001, ia);
					DatagramPacket p = new DatagramPacket(rec, 1024);
					p.setLength(0);
					while(true)
					{
						if(i==0)
						{
							System.out.println(msg);
							i++;
						}
						ds.receive(p);
						System.out.println(p);
						if(p.getLength()>=1)
						{
							i=0;
							msg = p.getData().toString();
							p.setLength(0);
						}
						System.out.println(i);
						// receive msg and let i=0;
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});*/
		System.out.println("begin");
		//th.start();
		System.out.println("end");
	} 	
}