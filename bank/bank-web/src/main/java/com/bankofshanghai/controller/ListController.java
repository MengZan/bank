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
import com.bankofshanghai.pojo.IpAddress;
import com.bankofshanghai.pojo.PhoneData;
import com.bankofshanghai.service.DataService;
import com.bankofshanghai.service.ListService;
import com.bankofshanghai.service.StatisticsService;
import com.github.pagehelper.PageInfo;

@Controller
public class ListController {
	
	@Autowired
	private ListService listService;
	
	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping("/list/ipshow")
	public String ipshow(HttpServletRequest request,HttpSession session,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos)
	throws Exception{
		int pageNo=pageNos;
		Long id = null;
		Integer ipdata = null;
		Integer ipsafe = null;
		List<IpAddress> list=listService.queryByPage_ip(pageNo, rows, id, ipdata, ipsafe);
		List<IpAddress> list_total = listService.select_ip(id, ipdata, ipsafe);
		
		int n = list_total.size();
		int[] count_ip = new int[2];
		count_ip=statisticsService.count_ip(list_total);
		request.setAttribute("ip_total", n); //总ip数
		request.setAttribute("ip_danger", count_ip[1]); //高风险ip数
		
		
		
		request.setAttribute("listss", list);
		PageInfo<IpAddress> pageInfo = new PageInfo<IpAddress>(list);
		request.setAttribute("recordCount", pageInfo.getPages()); //总页数
		request.setAttribute("pageNos", pageNo); //页号
		
		
		return "";
	}
	
	@RequestMapping("/list/ipadd")
	public String ipadd(HttpServletRequest request,HttpSession session,Integer ipdata,Integer ipsafe){
		
		IpAddress ip = new IpAddress();
		ip.setIp(ipdata);
		ip.setSafety(ipsafe);
		listService.addIp(ip);
		
		return "";
	}
	
	@RequestMapping("/list/ipdelete/{id}")
	public String ipdelete(HttpServletRequest request,HttpSession session,@PathVariable("ip_id") Long id){
		IpAddress ip = listService.getIpById(id);
		listService.deleteIp(ip);
		return "";
	}
	
	@RequestMapping("/list/ipedit/{id}")
	public String ipedit(HttpServletRequest request,HttpSession session,@PathVariable("ip_id") Long id){
		IpAddress ip = listService.getIpById(id);
		String ipsafe_t = request.getParameter("ipsafe");
		int ipsafe = Integer.parseInt(ipsafe_t);
		ip.setSafety(ipsafe);
		listService.updateIp(ip);
		return "";
	}
	
	@RequestMapping("/list/phoneshow")
	public String phoneshow(HttpServletRequest request,HttpSession session,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos)
	throws Exception{
		int pageNo=pageNos;
		Long id = null;
		Integer phonedata = null;
		Integer phonesafe = null;
		List<PhoneData> list=listService.queryByPage_phone(pageNo, rows, id, phonedata, phonesafe);
		List<PhoneData> list_total=listService.select_phone(id, phonedata, phonesafe);
		int n = list_total.size();
		int[] count_phone = new int[2];
		count_phone=statisticsService.count_phone(list_total);

		request.setAttribute("phone_total", n); //总手机数
		request.setAttribute("phone_danger", count_phone[1]); //高风险手机数
		
		request.setAttribute("listss", list);
		PageInfo<PhoneData> pageInfo = new PageInfo<PhoneData>(list);
		request.setAttribute("recordCount", pageInfo.getPages()); //总页数
		request.setAttribute("pageNos", pageNo); //页号
		
		return "";
	}
	
	@RequestMapping("/list/phoneadd")
	public String phoneadd(HttpServletRequest request,HttpSession session,Integer phonedata,Integer phonesafe){
		
		PhoneData phone = new PhoneData();
		phone.setPhoneNumber(phonedata);
		phone.setSafety(phonesafe);
		listService.addPhone(phone);
		
		return "";
	}
	
	@RequestMapping("/list/phonedelete/{id}")
	public String phonedelete(HttpServletRequest request,HttpSession session,@PathVariable("phone_id") Long id){
		PhoneData phone = listService.getPhoneById(id);
		listService.deletePhone(phone);
		return "";
	}
	
	@RequestMapping("/list/phoneedit/{id}")
	public String phoneedit(HttpServletRequest request,HttpSession session,@PathVariable("phone_id") Long id){
		PhoneData phone = listService.getPhoneById(id);
		String phonesafe_t = request.getParameter("phonesafe");
		int phonesafe = Integer.parseInt(phonesafe_t);
		phone.setSafety(phonesafe);
		listService.updatePhone(phone);
		return "";
	}

}
