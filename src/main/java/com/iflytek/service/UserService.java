package com.iflytek.service;

import com.iflytek.domain.User;

public interface UserService {
	  User findUserByUserName(String username) throws Exception;
}
