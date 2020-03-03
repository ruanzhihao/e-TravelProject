package com.iflytek.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PermissionDao {
	@Select(" select p.permissioncode from t_permission as p\r\n" + 
			"        inner join t_role_permission as rp on rp.perid=p.permissionid\r\n" + 
			"        inner join t_user_role ur on ur.roleid = rp.roleid\r\n" + 
			"        where ur.userid=#{userId}")
	 Set<String> findPermissionListByUserId(@Param("userId") int userId) throws Exception;
}
