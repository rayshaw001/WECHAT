package edu.hubu.daoImpl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.hubu.dao.FriendDao;
import edu.hubu.entities.Friend;

@Repository("FriendDao")
public class FriendDaoImpl implements FriendDao {
	@Resource
	private SessionFactory sessionFactory;

	// ��ȡ��ǰ�̰߳󶨵�session
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveFriend(Friend friend) {
		// TODO Auto-generated method stub
		this.getSession().save(friend);
		
	}

	@Override
	public Friend getFriendById(Long id) {
		// TODO Auto-generated method stub
		return (Friend)this.getSession().get(Friend.class,id);
	}

	@Override
	public void updateFriend(Friend friend) {
		// TODO Auto-generated method stub
		this.getSession().update(friend);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Friend> listFriendByHql(String hql) {
		// TODO Auto-generated method stub
		return (List<Friend>)this.getSession().createQuery(hql).list();
	}
}
