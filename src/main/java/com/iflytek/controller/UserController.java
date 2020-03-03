package com.iflytek.controller;

import com.iflytek.domain.User;
import com.iflytek.service.UserService;
import com.iflytek.vo.LoginUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	
	@PostMapping("/login")
	public String login(User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 获得用户主体
		Subject subject = SecurityUtils.getSubject();
		// 创建口令
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try {
			// 记住我
			token.setRememberMe(true);
			// 登录
			subject.login(token);
			// 获得用户主体
			LoginUserVo loginUserVo = (LoginUserVo) subject.getPrincipal();
			// 保存会话
			session.setAttribute("userInfo", loginUserVo.getUser());
			// 跳转到后台
			return "main";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/login.jsp";
	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws Exception {
		System.out.println(userService.findUserByUserName("admin").toString());
		return "";
	}

	@ResponseBody
	@RequestMapping("/userUpdate")
	public String userUpdate() {
		return "userUpdate";
	}

	@ResponseBody
	@RequestMapping("/userDelete")
	public String userDelete() {
		return "userDelete";
	}

	@ResponseBody
	@RequestMapping("/userAdd")
	public String userAdd() {
		return "userAdd";
	}

	@ResponseBody
	@RequestMapping("/userQuery")
	public String userQuery() {
		return "userQuery";
	}

	@ResponseBody
	@RequestMapping("/userExport")
	public String userExport() {
		return "userExport";
	}
}
