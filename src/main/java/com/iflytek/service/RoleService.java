package com.iflytek.service;

import java.util.Set;

public interface RoleService {
	 Set<String> findRoleListByUserId(int userId) throws Exception;
}
