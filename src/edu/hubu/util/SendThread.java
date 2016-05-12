package edu.hubu.util;

import java.io.OutputStream;

public class SendThread implements Runnable{
	
	Long id;
	OutputStream os;
	private String msg = null;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	boolean flag = false;
	public SendThread(Long id,OutputStream os) {
		
		this.id = id;
		this.os = os;
	}
	@Override
	public void run() {
		synchronized (os) {
			while(!flag)
			{
				try {
					if(msg==null)
					{
						os.wait();
					}
					else if(msg.equals("false") && msg.length() == 4)
					{
						return;
					}
					else 
					{
						os.write(msg.getBytes());
						msg = null;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}

}
