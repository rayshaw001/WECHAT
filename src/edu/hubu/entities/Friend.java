package edu.hubu.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Friend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Friend", catalog = "WECHAT")
@JsonIgnoreProperties(value={"userByBid"})
public class Friend implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5524041616413831886L;
	private Long id;
	private User userByAid;
	private User userByBid;
	private Long recentMsgID;

	// Constructors

	/** default constructor */
	public Friend() {
	}

	/** full constructor */
	public Friend(Long id, User userByAid, User userByBid,Long recentMsgID) {
		this.id = id;
		this.userByAid = userByAid;
		this.userByBid = userByBid;
		this.setRecentMsgID(recentMsgID);
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Aid", nullable = false)
	public User getUserByAid() {
		return this.userByAid;
	}

	public void setUserByAid(User userByAid) {
		this.userByAid = userByAid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Bid", nullable = false)
	public User getUserByBid() {
		return this.userByBid;
	}

	public void setUserByBid(User userByBid) {
		this.userByBid = userByBid;
	}
	
	@Column(name = "recentMsgId",nullable = true)
	public Long getRecentMsgID() {
		return recentMsgID;
	}

	public void setRecentMsgID(Long recentMsgID) {
		this.recentMsgID = recentMsgID;
	}

}