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

import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.service.DataService;
import com.bankofshanghai.service.UserService;
import com.bankofshanghai.service.UsermanService;
import com.github.pagehelper.PageInfo;

@Controller
public class DataController {

	@Autowired
	private DataService dataService;
	
	
	@RequestMapping("/datashowbyfromuser")
	public String datashowbyfromuser_t()
	{
		return "checkData";
	}
	
	@RequestMapping("/datashowbyfromuser/{fromuser}")
	public String datashowbyfromuser(HttpServletRequest request,HttpSession session,
			@PathVariable("fromuser") Integer fromuser,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos)
	
			throws Exception{
		int pageNo=pageNos;
		Integer touser=null;
		String tool=null;
		List<BankData> list=dataService.queryByPage(fromuser, touser, tool, pageNo, rows);
		
		request.setAttribute("listss", list);
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(list);
		request.setAttribute("recordCount", pageInfo.getPages()); //总页数
		request.setAttribute("pageNos", pageNo); //页号
		
		
		return "checkData";
	}
	
	@RequestMapping("/datashowbytouser")
	public String datashowbytouser(HttpServletRequest request,HttpSession session,
			@RequestParam(required = false, defaultValue = "1")Integer touser,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos)
	
			throws Exception{
		int pageNo=pageNos;
		Integer fromuser=null;
		String tool=null;
		List<BankData> list=dataService.queryByPage(fromuser, touser, tool, pageNo, rows);
		
		request.setAttribute("listss", list);
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(list);
		request.setAttribute("recordCount", pageInfo.getPages()); //总页数
		request.setAttribute("pageNos", pageNo); //页号
		
		
		return "checkData";
	}
	
	@RequestMapping("/datashow_fenye")
	public String datashow_fenye(HttpServletRequest request,@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos)
					throws Exception{
		int pageNo=pageNos;
		Integer fromuser=null;
		Integer touser=null;
		String tool=null;
		List<BankData> list=dataService.queryByPage(fromuser, touser, tool, pageNo, rows);
		request.setAttribute("listss", list);
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(list);
		request.setAttribute("recordCount", pageInfo.getPages()); //总页数
		request.setAttribute("pageNos", pageNo); //页号
		
		return "checkData";
	}
}
