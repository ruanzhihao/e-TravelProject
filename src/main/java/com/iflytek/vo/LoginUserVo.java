package com.iflytek.vo;



import java.io.Serializable;
import java.util.Set;

import com.iflytek.domain.User;

import lombok.Data;

/**
 * 登录用户类
 */
@Data
public class LoginUserVo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
    private Set<String> roles;//角色列表
    private Set<String> permissions;//权限列表

    public LoginUserVo(User user, Set<String> roles, Set<String> permissions) {
        this.user = user;
        this.roles = roles;
        this.permissions = permissions;
    }
}
