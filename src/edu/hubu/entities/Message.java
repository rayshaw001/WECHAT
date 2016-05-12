package edu.hubu.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Message",catalog = "WECHAT")
public class Message implements Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8325978079047718710L;
	private Long id;
	private User userByFromid;
	private User userByToid;
	private String msg;
	private List<User> users;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Long id) {
		this.id = id;
	}

	/** full constructor */
	public Message(Long id, User userByFromid, User userByToid, String msg,
			List<User> users) {
		this.id = id;
		this.userByFromid = userByFromid;
		this.userByToid = userByToid;
		this.msg = msg;
		this.users = users;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fromid")
	public User getUserByFromid() {
		return this.userByFromid;
	}

	public void setUserByFromid(User userByFromid) {
		this.userByFromid = userByFromid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "toid")
	public User getUserByToid() {
		return this.userByToid;
	}

	public void setUserByToid(User userByToid) {
		this.userByToid = userByToid;
	}

	@Column(name = "msg")
	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "message")
	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}