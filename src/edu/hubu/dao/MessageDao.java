package edu.hubu.dao;

import java.util.List;
import java.util.Set;

import edu.hubu.entities.Message;

public interface MessageDao {
	public void saveMessage(Message message);
	public Message getMessageById(Long id); 
	public void	updateMessage(Message message);
	public List<Message> listMessageByHql(String hql);

}
