package com.bankofshanghai.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankofshanghai.mypojo.BankResult;
import com.bankofshanghai.mypojo.MyPageList;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankRule;
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
	
	
	
	//显示ip
	@RequestMapping(value="/ipmanage" ,method=RequestMethod.GET)
	@ResponseBody
	public BankResult ipshow(HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos)
	throws Exception{
		int pageNo=pageNos;
		Long id = null;
		Integer ipdata = null;
		Integer ipsafe = null;
		Date date1=null;
		Date date2=null;
		List<IpAddress> iplist=listService.queryByPage_ip(pageNo, rows, id, ipdata, ipsafe,date1,date2);

		
		
		
		request.setAttribute("listss", iplist);
		PageInfo<IpAddress> pageInfo = new PageInfo<IpAddress>(iplist);
		MyPageList<IpAddress> list = new MyPageList<>();
		list.setList(iplist);
		list.setPageCount(pageInfo.getPages());
		list.setPageNos(pageNos);
		request.setAttribute("recordCount", pageInfo.getPages()); //总页数
		request.setAttribute("pageNos", pageNo); //页号
		
		
		return BankResult.ok(list);
	}
	
	
	@RequestMapping(value="/ipmanage/{id}" , method=RequestMethod.GET)
	@ResponseBody
	public BankResult getipById(@PathVariable("id") Long id) {
		IpAddress ip = listService.getIpById(id);
		return BankResult.ok(ip);
	}
	
	
	//添加ip
	@RequestMapping(value="/ipmanage" ,method=RequestMethod.POST)
	@ResponseBody
	public BankResult ipadd(IpAddress ip) {

		Date date=new Date();
		ip.setDatetime(date);
		if(listService.addIp(ip)==1)
		    return BankResult.ok();
		return BankResult.build(0, "添加失败");
	}
	
	//通过safety和日期查看ip
	@RequestMapping(value="/ipshow", method=RequestMethod.POST)
	@ResponseBody
	public BankResult ipshow( Integer safety, String date_s1,String date_e1,
			Model model,@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos) 
					throws Exception{
		Long id = null;
		Integer ipdata = null;
		Integer ipsafe = safety;
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
		List<IpAddress> iplist=listService.queryByPage_ip(pageNos, rows, id, ipdata, ipsafe,date_s,date_e);

		PageInfo<IpAddress> pageInfo = new PageInfo<IpAddress>(iplist);
		MyPageList<IpAddress> list = new MyPageList<>();
		list.setList(iplist);
		list.setPageCount(pageInfo.getPages());
		list.setPageNos(pageNos);
		return BankResult.ok(list);
	}
	
	
	//修改ip
	@RequestMapping(value="/ipmanage/{id}", method=RequestMethod.POST)
	@ResponseBody
	public BankResult ipedit(HttpServletRequest request,@PathVariable(value="id") Long id,IpAddress ip,Integer ipsafe){
		
		ip.setId(id);
		ip.setSafety(ipsafe);
		Date date=new Date();
		ip.setDatetime(date);
		if(listService.updateIp(ip)==1)
		    return BankResult.ok();
		
		return BankResult.build(0, "更新失败");
	}
	
	
	//删除ip
	@RequestMapping(value="/ipmanage/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public BankResult ipdelete(HttpServletRequest request,@PathVariable("id") Long id){
		IpAddress ip = listService.getIpById(id);
		if(listService.deleteIp(ip)==1)
		return BankResult.ok();
		
		return BankResult.build(0, "删除失败");
	}
	
	
	
	//显示phone
		@RequestMapping(value="/phonemanage" ,method=RequestMethod.GET)
		@ResponseBody
		public BankResult phoneshow(HttpServletRequest request,
				@RequestParam(required = false, defaultValue = "10") int rows,
				@RequestParam(required = false, defaultValue = "1") int pageNos)
		throws Exception{
			int pageNo=pageNos;
			Long id = null;
			Integer PhoneData = null;
			Integer phonesafe = null;
			Date date1=null;
			Date date2=null;
			List<PhoneData> phonelist=listService.queryByPage_phone(pageNo, rows, id, PhoneData, phonesafe,date1,date2);
			
			
			
			request.setAttribute("listss", phonelist);
			PageInfo<PhoneData> pageInfo = new PageInfo<PhoneData>(phonelist);
			MyPageList<PhoneData> list = new MyPageList<>();
			list.setList(phonelist);
			list.setPageCount(pageInfo.getPages());
			list.setPageNos(pageNos);
			request.setAttribute("recordCount", pageInfo.getPages()); //总页数
			request.setAttribute("pageNos", pageNo); //页号
			
			
			return BankResult.ok(list);
		}
		
		
		@RequestMapping(value="/phonemanage/{id}" , method=RequestMethod.GET)
		@ResponseBody
		public BankResult getphoneById(@PathVariable("id") Long id) {
			PhoneData phone = listService.getPhoneById(id);
			return BankResult.ok(phone);
		}
		
		//添加phone
		@RequestMapping(value="/phonemanage" ,method=RequestMethod.POST)
		@ResponseBody
		public BankResult phoneadd(PhoneData phone) {

			Date date=new Date();
			phone.setDatetime(date);
			if(listService.addPhone(phone)==1)
			    return BankResult.ok();
			return BankResult.build(0, "添加失败");
		}
		
		//通过safety和日期查看phone
		@RequestMapping(value="/phoneshow", method=RequestMethod.POST)
		@ResponseBody
		public BankResult phoneshow(Integer safety, String date_s1, String date_e1,
				Model model,@RequestParam(required = false, defaultValue = "10") int rows,
				@RequestParam(required = false, defaultValue = "1") int pageNos) 
						throws Exception{
			Long id = null;
			Integer PhoneData = null;
			Integer phonesafe = safety;
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
			List<PhoneData> phonelist=listService.queryByPage_phone(pageNos, rows, id, PhoneData, phonesafe,date_s,date_e);

			PageInfo<PhoneData> pageInfo = new PageInfo<PhoneData>(phonelist);
			MyPageList<PhoneData> list = new MyPageList<>();
			list.setList(phonelist);
			list.setPageCount(pageInfo.getPages());
			list.setPageNos(pageNos);
			return BankResult.ok(list);
		}
		
		
		//修改phone
		@RequestMapping(value="/phonemanage/{id}", method=RequestMethod.POST)
		@ResponseBody
		public BankResult phoneedit(HttpServletRequest request,@PathVariable(value="id") Long id,PhoneData phone,Integer phonesafe){
			
			phone.setId(id);
			phone.setSafety(phonesafe);

			Date date=new Date();
			phone.setDatetime(date);
			if(listService.updatePhone(phone)==1)
			    return BankResult.ok();
			
			return BankResult.build(0, "更新失败");
		}
		
		
		//删除phone
		@RequestMapping(value="/phonemanage/{id}", method=RequestMethod.DELETE)
		@ResponseBody
		public BankResult phonedelete(HttpServletRequest request,@PathVariable("id") Long id){
			PhoneData phone = listService.getPhoneById(id);
			if(listService.deletePhone(phone)==1)
			return BankResult.ok();
			
			return BankResult.build(0, "删除失败");
		}

}
