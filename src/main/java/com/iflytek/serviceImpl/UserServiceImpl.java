package com.iflytek.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytek.dao.UserDao;
import com.iflytek.domain.User;
import com.iflytek.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	 @Autowired
	    private UserDao userDao;

	public User findUserByUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findUserByUserName(username);
	}
}
