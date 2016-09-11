package com.bankofshanghai.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankofshanghai.mypojo.BankResult;
import com.bankofshanghai.mypojo.MyPageList;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.service.UserService;
import com.bankofshanghai.service.UsermanService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/ajax")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UsermanService usermanService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public BankResult login(HttpSession session, String username, String password)
			throws Exception {
		if(userService.login(username, password)==0){
			// 登陆成功，在session中保存用户身份信息
			session.setAttribute("username", username);
			return BankResult.ok(username);
		}
		String msg = null;
		// 用户名不存在
		if(userService.login(username, password)==1){
			msg = "用户名不存在";
		}
		// 密码错误
		if(userService.login(username, password)==2){
			msg = "密码错误";
		}
		return BankResult.build(1, msg, username);
	}
	
	// 登出
	@RequestMapping("/logout")
	@ResponseBody
	public BankResult logout(HttpSession session){
		session.invalidate();
		return BankResult.ok();
	}
	

	
	@RequestMapping(value="/usermanage", method=RequestMethod.GET)
	@ResponseBody
	public BankResult usermanage(HttpServletRequest request,HttpSession session,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page){
		int pageNo=page;
		int usertype_t=7;
		Long userid=null;
		Date date_s=null;
		Date date_e=null;
		List<BankUser> userlist=usermanService.queryByPage(pageNo, pageSize, userid, usertype_t,date_s,date_e);

		PageInfo<BankUser> pageInfo = new PageInfo<BankUser>(userlist);
		MyPageList<BankUser> list = new MyPageList<>();
		list.setList(userlist);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
	}
	

	
	//查询用户名单
	@RequestMapping(value="/usershow", method=RequestMethod.POST)
	@ResponseBody
	public BankResult usershow(HttpServletRequest request,HttpSession session,
			@RequestParam(required = false, defaultValue = "7") Integer usertype,String date_s,String date_e,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page)
					throws Exception{
		int pageNo=page;
		Long userid=null;
		Date date_s1=null;
		Date date_e1=null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
 	    if(date_s!=null) {
 	    	 date_s1=simpleDateFormat.parse(date_s);
 	    }
 	    else{
 	    	 date_s1=null;
 	    }
 	    if(date_e!=null){
 	    	 date_e1=simpleDateFormat.parse(date_e);
 	    }
 	    else{
 	    	 date_e1=null;
 	    }
		List<BankUser> userlist=usermanService.queryByPage(pageNo, pageSize, userid, usertype,date_s1,date_e1);

		PageInfo<BankUser> pageInfo = new PageInfo<BankUser>(userlist);
		MyPageList<BankUser> list = new MyPageList<>();
		list.setList(userlist);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
	}

	@RequestMapping(value="/usermanage/{id}", method=RequestMethod.GET)
	@ResponseBody
	public BankResult getuser(HttpServletRequest request,HttpSession session,@PathVariable("id") Long id){
		
		BankUser user=usermanService.getUserByID(id);
	    return BankResult.ok(user);
		
	}
	
	@RequestMapping(value="/usermanage/{id}", method=RequestMethod.POST)
	@ResponseBody
	public BankResult userupdate(@PathVariable(value="id") Long id,BankUser user,Integer usertype){
		
		user.setId(id);
		user.setUsertype(usertype);
		if(usermanService.UserUpdate(user)==1)
	    return BankResult.ok();
		
	return BankResult.build(1, "更新失败");
	}
	

}
