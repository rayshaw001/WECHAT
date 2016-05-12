package edu.hubu.service;

import java.util.List;
import java.util.Set;

import edu.hubu.entities.User;

public interface UserService {
	public void saveUser(User user);
	public User getUserById(Long id); 
	public void	updateUser(User user);
	public List<User> listUserByHql(String hql);

}
