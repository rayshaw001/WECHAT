package edu.hubu.action;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.interfaces.DSAKey;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test {
	@SuppressWarnings("unchecked")
	@RequestMapping("test.do")
	public String t(HttpServletRequest request, String name) throws IOException
	{
		String IP = request.getRemoteAddr();
		int port = request.getRemotePort();
		request.setAttribute("IP", IP);
		request.setAttribute("port", port);
		//DatagramSocket ds = new DatagramSocket();
		//Thread thd = new newThread(IP, port);
		//thd.start();
		request.setAttribute("ports", ((Map<Long, Integer>)request.getServletContext().getAttribute("sends")).size());
		return "index";
	}
	class newThread extends Thread{
		String IP;
		int port;
		public newThread(String IP,int port) {
			// TODO Auto-generated constructor stub
			this.IP = IP;
			this.port = port;
		}
		@Override
		public void run()
		{
			String data = "hello";
			try {
				//wait(2000);
				DatagramSocket ds = new DatagramSocket();
				DatagramPacket dp = new DatagramPacket(data.getBytes(), data.getBytes().length);
				dp.setPort(port);
				dp.setAddress(InetAddress.getByName(IP));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
}