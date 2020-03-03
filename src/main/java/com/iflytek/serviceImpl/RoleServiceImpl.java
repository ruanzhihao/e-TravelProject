package com.iflytek.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytek.dao.RoleDao;
import com.iflytek.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	public Set<String> findRoleListByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return roleDao.findRoleListByUserId(userId);
	}
}
