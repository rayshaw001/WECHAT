package edu.hubu.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;






import edu.hubu.dao.UserDao;
import edu.hubu.daoImpl.UserDaoImpl;
import edu.hubu.entities.User;
import edu.hubu.serviceImpl.UserServiceImpl;

public class SessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		UserServiceImpl sService = new UserServiceImpl();
		User u = (User)arg0.getSession().getAttribute("user");
		UserDao userDao = new UserDaoImpl();
		sService.setUserDao(userDao);
		u.setStatus("离线");
		sService.updateUser(u);
	}
}
