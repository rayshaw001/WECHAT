package edu.hubu.serviceImpl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.hubu.dao.MessageDao;
import edu.hubu.entities.Message;
import edu.hubu.service.MessageService;

@Service("messageServcie")
public class MessageServiceImpl implements MessageService{

	@Resource
	private MessageDao msgDao;
	public MessageDao getMsgDao() {
		return msgDao;
	}

	public void setMsgDao(MessageDao msgDao) {
		this.msgDao = msgDao;
	}

	@Override
	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
		this.getMsgDao().saveMessage(message);
		
	}

	@Override
	public Message getMessageById(Long id) {
		// TODO Auto-generated method stub
		return this.getMsgDao().getMessageById(id);
	}

	@Override
	public void updateMessage(Message message) {
		// TODO Auto-generated method stub
		this.getMsgDao().updateMessage(message);
		
	}

	@Override
	public List<Message> listMessageByHql(String hql) {
		// TODO Auto-generated method stub
		return this.getMsgDao().listMessageByHql(hql);
	}

}
