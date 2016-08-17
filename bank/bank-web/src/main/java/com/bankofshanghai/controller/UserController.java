package com.bankofshanghai.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankofshanghai.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
//	@RequestMapping("/user/{userId}")
//	@ResponseBody
//	public BankUser getUserById(@PathVariable Long userId) {
//		BankUser user = userService.getUserByID(userId);
//		return user;
//	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, Model model, String username, String password)
			throws Exception {
		// 调用service进行用户身份验证
		if(userService.login(username, password)==0){
			// 登陆成功，在session中保存用户身份信息
			session.setAttribute("username", username);
			// 重定向到商品列表页面
			return "redirect:/";
		}
		// 用户名不存在
		if(userService.login(username, password)==1){
			model.addAttribute("message","用户名不存在");
		}
		// 密码错误
		if(userService.login(username, password)==2){
			model.addAttribute("message","密码错误");
		}
		model.addAttribute("username",username);
		return "login";
	}
	
	// 登出
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
}
