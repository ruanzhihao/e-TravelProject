package com.iflytek.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleDao {
	@Select(" select r.rolename from t_role as r\r\n" + 
			"        inner  join  t_user_role as ur on ur.roleid=r.roleid\r\n" + 
			"        where  ur.userid=#{userId}")
	 Set<String> findRoleListByUserId(@Param("userId") int userId) throws Exception;
}
