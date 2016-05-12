package edu.hubu.service;

import java.util.List;

import edu.hubu.entities.Friend;

public interface FriendService {
	public void saveFriend(Friend friend);
	public Friend getFriendById(Long id); 
	public void	updateFriend(Friend friend);
	public List<Friend> listFriendByHql(String hql);

}
