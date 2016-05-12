package edu.hubu.daoImpl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.hubu.dao.UserDao;
import edu.hubu.entities.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	@Resource
	private SessionFactory sessionFactory;

	// ��ȡ��ǰ�̰߳󶨵�session
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.getSession().save(user);
		
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return (User)this.getSession().get(User.class,id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.getSession().update(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUserByHql(String hql) {
		// TODO Auto-generated method stub
		return (List<User>)this.getSession().createQuery(hql).list();
	}
}
