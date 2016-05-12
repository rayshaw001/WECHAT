package edu.hubu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		
		
		return isAllow(request,response);
		
		//response.getWriter().print(msg + status);
	}
	private boolean isAllow(HttpServletRequest request,HttpServletResponse response)
	{
		boolean flag = true;
		String URI = request.getRequestURI();
		String msg ="请登录";
		String allow[] = {"loging","test.do"};
		for(String s:allow)
		{
			if(URI.contains(s))
			{
				return flag;
			}
		}
		if(URI.contains("loged"))
		{
			if(request.getSession().getAttribute("user")!=null)
			{
				flag = true;
				//msg = "request successed";
			}
			else
			{
				flag = false;
			}
		}
		else
		{
			flag = false;
		}
		
		
		return true;
	}

}
