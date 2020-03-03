package com.iflytek.realm;

import com.iflytek.domain.User;
import com.iflytek.service.PermissionService;
import com.iflytek.service.RoleService;
import com.iflytek.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.iflytek.vo.LoginUserVo;

import java.util.Set;

/**
 * 自定义UserRealm
 */
public class UserRealm extends AuthorizingRealm {

    //注入UserService
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    public String getName() {
        return  this.getClass().getSimpleName();
    }

    /**
     * 授权（为当前登录的用户授予相应的权限）
     * @param principalCollection 当前登录对象（主体对象）
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //创建授权器对象
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //获取当前登录主体
        LoginUserVo loginUserVo=(LoginUserVo) principalCollection.getPrimaryPrincipal();
        //获取角色列表
        Set<String> roles=loginUserVo.getRoles();
        //获取权限列表
        Set<String> permissions=loginUserVo.getPermissions();
        if(roles!=null && roles.size()>0)
        {
            info.setRoles(roles);
        }
        if(permissions!=null && permissions.size()>0)
        {
            info.setStringPermissions(permissions);
        }
        return info;

    }

    /**
     *  身份验证（为当前用于验证身份）
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //得到当前用户登录
        //账号
        String username=authenticationToken.getPrincipal().toString();
        //密码
        String password=authenticationToken.getCredentials().toString();
        try {
            User user=userService.findUserByUserName(username);
            Set<String> roles=roleService.findRoleListByUserId(user.getUserid());
            Set<String> permissions=permissionService.findPermissionListByUserId(user.getUserid());
            if(user!=null)
            {
                //创建用户对象，传入用户信息，角色列表，权限列表
                LoginUserVo loginUserVo=new LoginUserVo(user,roles,permissions);
                //创建盐值（可以以用户名作为盐值）
                ByteSource salt=ByteSource.Util.bytes(user.getUsername());
                //创建身份验证对象
                //参数1.用户名 2.密码 3.盐值 4.域名（可以填写任何字符串）
                SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(loginUserVo,user.getPassword(),salt,getName());
                return info;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
