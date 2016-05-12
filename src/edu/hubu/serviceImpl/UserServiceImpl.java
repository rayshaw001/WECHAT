package edu.hubu.serviceImpl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.hubu.dao.UserDao;
import edu.hubu.entities.User;
import edu.hubu.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.getUserDao().saveUser(user);
		
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return this.getUserDao().getUserById(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.getUserDao().updateUser(user);
		
	}

	@Override
	public List<User> listUserByHql(String hql) {
		// TODO Auto-generated method stub
		return this.getUserDao().listUserByHql(hql);
	}

}
