package com.iflytek.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iflytek.domain.User;

@Mapper
public interface UserDao {
	@Select(" select * from t_user where username=#{username}")
	 User findUserByUserName(@Param("username") String username) throws Exception;
}
