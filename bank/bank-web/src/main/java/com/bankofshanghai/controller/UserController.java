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
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.service.DataService;
import com.bankofshanghai.service.UserService;
import com.bankofshanghai.service.UsermanService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/ajax")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DataService dataService;
	
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
	
	@RequestMapping("/checkusertype")
	public String checkusertype(HttpServletRequest request,HttpSession session,Long userid)
			throws Exception{
		BankUser user = usermanService.getUserByID(userid);
		BankData data = dataService.getDataByID(userid);
		Integer usertype=user.getUsertype();
		if(usertype==0)//黑名单
		{
			data.setSafeLevel(99);
		}
		else{
	    
		if(usertype==1)//白名单
		{
			data.setSafeLevel(0);
			
		}
		
		else // 灰名单，高风险ip、手机号等
		{
			
		}
			
		}
		dataService.updateDataSafe(data);
		return "";
	}

	
	@RequestMapping(value="/usermanage", method=RequestMethod.GET)
	@ResponseBody
	public BankResult usermanage(HttpServletRequest request,HttpSession session,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos){
		int pageNo=pageNos;
		int usertype_t=7;
		Long userid=null;
		Date date_s=null;
		Date date_e=null;
		List<BankUser> userlist=usermanService.queryByPage(pageNo, rows, userid, usertype_t,date_s,date_e);

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
			Integer usertype,String date_s1,String date_e1,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos)
					throws Exception{
		int pageNo=pageNos;
		Long userid=null;
		Date date_s=null;
		Date date_e=null;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
 	    if(date_s1!=null) {
 	    	 date_s=simpleDateFormat.parse(date_s1);
 	    }
 	    else{
 	    	 date_s=null;
 	    }
 	    if(date_e1!=null){
 	    	 date_e=simpleDateFormat.parse(date_e1);
 	    }
 	    else{
 	    	 date_e=null;
 	    }
		List<BankUser> userlist=usermanService.queryByPage(pageNo, rows, userid, usertype,date_s,date_e);

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
	
	@RequestMapping(value="/usermanage", method=RequestMethod.POST)
	@ResponseBody
	public BankResult userupdate(BankUser user){
		
		
		if(usermanService.UserUpdate(user)==1)
	    return BankResult.ok();
		
	return BankResult.build(0, "更新失败");
	}
	
//	@RequestMapping("/list/usertypeupdate")
//	public String usertypeupdate(HttpServletRequest request,HttpSession session,BankUser user){
//		
//		Long userid = user.getId();
//		String usertype_t = request.getParameter("usertype");
//		int usertype = Integer.parseInt(usertype_t);
//		usermanService.UsertypeUpdata(userid, usertype);
//		return "usermanage";
//	}
	
}
