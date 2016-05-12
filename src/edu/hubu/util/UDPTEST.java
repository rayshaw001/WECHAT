package edu.hubu.util;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Map;

public class UDPTEST {

	public static void main(String[] args) {
		Thread thread = new Thread(new Initial());
		thread.start();
	}
}


class Initial implements Runnable
{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean flag = true;
		
		Long id;
		DatagramSocket ds;
		DatagramPacket dp;
		byte [] data = new byte[10];
		try {
			dp = new DatagramPacket(data, 10);
			ds = new DatagramSocket(808);
			
			while(flag)
			{
				try {
					
					ds.receive(dp);
					id = Long.parseLong(new String(dp.getData()).trim());
					//ports.put(id, dp.getPort());
					System.out.println("port:id="+dp.getPort()+":"+id);
				}			
				catch(Exception e){
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}