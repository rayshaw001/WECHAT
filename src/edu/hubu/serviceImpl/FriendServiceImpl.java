package edu.hubu.serviceImpl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.hubu.dao.FriendDao;
import edu.hubu.entities.Friend;
import edu.hubu.service.FriendService;

@Service("friendService")
public class FriendServiceImpl implements FriendService{

	@Resource
	private FriendDao friendDao;
	public FriendDao getFriendDao() {
		return friendDao;
	}

	public void setFriendDao(FriendDao friendDao) {
		this.friendDao = friendDao;
	}

	@Override
	public void saveFriend(Friend friend) {
		// TODO Auto-generated method stub
		this.getFriendDao().saveFriend(friend);
		
	}

	@Override
	public Friend getFriendById(Long id) {
		// TODO Auto-generated method stub
		return this.getFriendDao().getFriendById(id);
	}

	@Override
	public void updateFriend(Friend friend) {
		// TODO Auto-generated method stub
		this.getFriendDao().updateFriend(friend);
		
	}

	@Override
	public List<Friend> listFriendByHql(String hql) {
		// TODO Auto-generated method stub
		return this.getFriendDao().listFriendByHql(hql);
	}

}
