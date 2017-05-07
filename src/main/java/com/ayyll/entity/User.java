package com.ayyll.entity;

import java.io.Serializable;

/**
 * @author LJC 
 * 用户实体
 */
/**
 * @author Administrator
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer uid;
	private String username;
	private String password;
	private String headimg; // 用户头像
	private int rank;//等级
	private int exp;//经验值
	private String head_title;//头衔
	public String getHead_title() {
		return head_title;
	}
	public void setHead_title(String head_title) {
		this.head_title = head_title;
	}
	public User() {
		super();
	}
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", rank=" + rank
				+ ", exp=" + exp + ", head_title=" + head_title + "]";
	}
	
}
