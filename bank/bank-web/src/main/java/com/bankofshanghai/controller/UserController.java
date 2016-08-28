package com.bankofshanghai.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankofshanghai.mypojo.BankResult;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.service.DataService;
import com.bankofshanghai.service.StatisticsService;
import com.bankofshanghai.service.UserService;
import com.bankofshanghai.service.UsermanService;
import com.github.pagehelper.PageInfo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DataService dataService;
	
	@Autowired
	private UsermanService usermanService;
	

	@Autowired
	private StatisticsService statisticsService;
	
//	@RequestMapping("/user/1000")
//	@ResponseBody
//	public BankResult getUserById(@PathVariable Long userId) {
//		BankUser user = new BankUser();
//		user=usermanService.getUserByID((long) 1 );
//		return BankResult.ok(user);
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

	
	@RequestMapping("/usermanage")
	public String usermanage(HttpServletRequest request,HttpSession session,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos){
		int pageNo=pageNos;
		int usertype_t=7;
		Long userid=null;
		List<BankUser> list=usermanService.queryByPage(pageNo, rows, userid, usertype_t);
		
		int n = list.size();
		int[] count_user = new int[4];
		count_user=statisticsService.count_user(list);
		request.setAttribute("user_total", n); //总名单数
		request.setAttribute("blackuser", count_user[0]); //黑名单数
		request.setAttribute("whiteuser", count_user[1]); //白名单数
		request.setAttribute("grayuser", count_user[2]); //灰名单数
		request.setAttribute("user_danger", count_user[3]); //高风险账户
		
		request.setAttribute("listss", list);
		PageInfo<BankUser> pageInfo = new PageInfo<BankUser>(list);
		request.setAttribute("recordCount", pageInfo.getPages()); //总页数
		request.setAttribute("pageNos", pageNo); //页号
		
		request.setAttribute("userid_t", userid);
		request.setAttribute("selectusertype", usertype_t);
		return "usermanage";
	}
	
	@RequestMapping("/usershow")
	public String usershow(HttpServletRequest request,HttpSession session,
			@RequestParam(required = false, defaultValue = "999")Long userid,
			@RequestParam(required = false, defaultValue = "7")String usertype,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos)
	throws Exception{
		int pageNo=pageNos;
		int usertype_t=Integer.parseInt(usertype);
		if(userid==999) userid=null;
		List<BankUser> list=usermanService.queryByPage(pageNo, rows, userid, usertype_t);
		
		request.setAttribute("listss", list);
		PageInfo<BankUser> pageInfo = new PageInfo<BankUser>(list);
		request.setAttribute("recordCount", pageInfo.getPages()); //总页数
		request.setAttribute("pageNos", pageNo); //页号
		
		request.setAttribute("userid_t", userid);
		request.setAttribute("selectusertype", usertype_t);
		
		return "usermanage";
	}

	
	@RequestMapping("/userupdate/{id}")
	public String userupdate(HttpServletRequest request,HttpSession session,@PathVariable("id") Long id, Model model){
		
		BankUser user=usermanService.getUserByID(id);
		model.addAttribute("user", user);
		return "userupdate";
	}
	
	@RequestMapping("/usertypeupdate")
	public String usertypeupdate(HttpServletRequest request,HttpSession session,BankUser user){
		
		Long userid = user.getId();
		String usertype_t = request.getParameter("usertype");
		int usertype = Integer.parseInt(usertype_t);
		usermanService.UsertypeUpdata(userid, usertype);
		return "usermanage";
	}
	
}
