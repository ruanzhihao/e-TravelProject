package com.iflytek.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iflytek.dao.PermissionDao;
import com.iflytek.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionDao permissionDao;

	public Set<String> findPermissionListByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return permissionDao.findPermissionListByUserId(userId);
	}
}
