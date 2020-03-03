package com.iflytek.domain;

import lombok.Data;

@Data
public class User {
    Integer userid;
    String username;
    String password;
	String realname;
	public User(Integer userid, String username, String password, String realname) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.realname = realname;
	}
	
}
