package edu.hubu.daoImpl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.hubu.dao.MessageDao;
import edu.hubu.entities.Message;

@Repository
public class MessageDaoImpl implements MessageDao{
	@Resource
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
		this.getSession().save(message);
	}

	@Override
	public Message getMessageById(Long id) {
		// TODO Auto-generated method stub
		return (Message)this.getSession().get(Message.class, id);
	}

	@Override
	public void updateMessage(Message message) {
		// TODO Auto-generated method stub
		this.getSession().update(message);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> listMessageByHql(String hql) {
		// TODO Auto-generated method stub
		return (List<Message>)this.getSession().createQuery(hql).list();
	}

}
