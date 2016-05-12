package edu.hubu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/download")
public class FileDownloadController {
	@RequestMapping(value="/WECHAT",method=RequestMethod.GET)
	public void wechat(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		int length = 1024;
		byte [] buffer = new byte[1024];
		String filePath = request.getServletContext().getRealPath("/Resource") + "/WECHAT.apk";
		Path path = Paths.get(filePath);
		File file = path.toFile();
		
		response.setContentType("text/plain");
		response.setHeader("Location", "WECHAT.apk");
		response.setHeader("Content-Disposition",
				"attachment; filename=WECHAT.apk");
		
		
		FileInputStream fis = new FileInputStream(file); 
		ServletOutputStream fos = response.getOutputStream();
		while((length=fis.read(buffer))!=-1)
		{
			fos.write(buffer,0,length);
		}
		fos.flush();
		fos.close();
		fis.close();
		
	}
}
