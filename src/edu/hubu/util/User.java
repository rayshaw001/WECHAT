package edu.hubu.util;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.hubu.entities.Friend;
import edu.hubu.entities.Message;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "User", schema = "dbo", catalog = "WECHAT")
public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private Message message;
	private String name;
	private String nickname;
	private String status;
	private String password;
	private String ip;
	private List<Message> messagesForToid ;
	private List<Message> messagesForFromid ;
	private List<Friend> friendsForAid;
	private List<Friend> friendsForBid;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Long id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public User(Long id, Message message, String name, String nickname,
			String status, String password, String ip,
			List<Message> messagesForToid, List<Message> messagesForFromid,
			List<Friend> friendsForAid, List<Friend> friendsForBid) {
		this.id = id;
		this.message = message;
		this.name = name;
		this.nickname = nickname;
		this.status = status;
		this.password = password;
		this.ip = ip;
		this.messagesForToid = messagesForToid;
		this.messagesForFromid = messagesForFromid;
		this.friendsForAid = friendsForAid;
		this.friendsForBid = friendsForBid;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lastmsgId")
	public Message getMessage() {
		return this.message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "nickname", length = 40)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "status", length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "IP")
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByToid")
	public List<Message> getMessagesForToid() {
		return this.messagesForToid;
	}

	public void setMessagesForToid(List<Message> messagesForToid) {
		this.messagesForToid = messagesForToid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByFromid")
	public List<Message> getMessagesForFromid() {
		return this.messagesForFromid;
	}

	public void setMessagesForFromid(List<Message> messagesForFromid) {
		this.messagesForFromid = messagesForFromid;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "userByAid")
	public List<Friend> getFriendsForAid() {
		return this.friendsForAid;
	}

	public void setFriendsForAid(List<Friend> friendsForAid) {
		this.friendsForAid = friendsForAid;
	}

	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "userByBid")
	public List<Friend> getFriendsForBid() {
		return this.friendsForBid;
	}

	public void setFriendsForBid(List<Friend> friendsForBid) {
		this.friendsForBid = friendsForBid;
	}

}