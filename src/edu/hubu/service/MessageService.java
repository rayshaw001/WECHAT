package edu.hubu.service;

import java.util.List;
import java.util.Set;

import edu.hubu.entities.Message;

public interface MessageService {
	public void saveMessage(Message message);
	public Message getMessageById(Long id); 
	public void	updateMessage(Message message);
	public List<Message> listMessageByHql(String hql);

}
