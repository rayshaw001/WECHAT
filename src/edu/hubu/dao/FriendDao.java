package edu.hubu.dao;

import java.util.List;

import edu.hubu.entities.Friend;

public interface FriendDao {
	public void saveFriend(Friend friend);
	public Friend getFriendById(Long id); 
	public void	updateFriend(Friend friend);
	public List<Friend> listFriendByHql(String hql);
}
