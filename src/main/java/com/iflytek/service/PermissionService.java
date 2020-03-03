package com.iflytek.service;

import java.util.Set;

public interface PermissionService {
	Set<String> findPermissionListByUserId(int userId) throws Exception;
}
