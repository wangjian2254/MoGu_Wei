package com.liyu.pluginframe.beans;

import java.io.Serializable;

public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String writepwd;
	private String isactive;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getWritepwd() {
		return writepwd;
	}
	public void setWritepwd(String writepwd) {
		this.writepwd = writepwd;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getUrlParam(){
		return "&UserName="+ this.username + "&UserPwd=" + this.password;
	}
}
