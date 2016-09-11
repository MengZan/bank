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
import com.bankofshanghai.mypojo.MyDataList;
import com.bankofshanghai.mypojo.MyPageList;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.service.DataService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/ajax")
public class DataController {

	@Autowired
	private DataService dataService;
	
	
	@RequestMapping("/datashowbyfromuser")
	public String datashowbyfromuser_t()
	{
		return "checkData";
	}
	
	@RequestMapping(value="/datashowbyfromuser/{fromuser}", method=RequestMethod.GET)
	@ResponseBody
	public BankResult datashowbyfromuser(HttpServletRequest request,
			@PathVariable("fromuser") Long fromuser,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page)
	
			throws Exception{
		int pageNo=page;
		Long touser=null;
		String tool=null;
		Integer moneyint=0;
		String fromplace=null;
		Integer safety=null;
		Date date_s=null;
		Date date_e=null;
		Integer safe_action=0;
		List<BankData> datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety,date_s,date_e, safe_action,pageNo, pageSize);
		
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		
		MyPageList<BankData> list = new MyPageList<>();
		list.setList(datalist);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
		
	}
	
	@RequestMapping(value="/datashowbytouser/{touser}", method=RequestMethod.GET)
	@ResponseBody
	public BankResult datashowbytouser(HttpServletRequest request,HttpSession session,
			@PathVariable("touser")Long touser,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page)
	
			throws Exception{
		int pageNo=page;
		Long fromuser=null;
		String tool=null;
		Integer moneyint=0;
		String fromplace=null;
		Integer safety=null;
		Date date_s=null;
		Date date_e=null;
		Integer safe_action=0;
		List<BankData> datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety,date_s,date_e, safe_action,pageNo, pageSize);
		
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		MyPageList<BankData> list = new MyPageList<>();
		list.setList(datalist);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
		
	}
	
	@RequestMapping(value="/datashowbytool/{tool}", method=RequestMethod.GET)
	@ResponseBody
	public BankResult datashowbytool(HttpServletRequest request,HttpSession session,
			@PathVariable("tool")String tool,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page)
	
			throws Exception{
		int pageNo=page;
		Long fromuser=null;
		Long touser=null;
		Integer moneyint=0;
		String fromplace=null;
		Integer safety=null;
		Date date_s=null;
		Date date_e=null;
		Integer safe_action=0;
		List<BankData> datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety,date_s,date_e, safe_action,pageNo, pageSize);
		
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		MyPageList<BankData> list = new MyPageList<>();
		list.setList(datalist);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
		
	}
	
	@RequestMapping(value="/datashowbymoney/{money}", method=RequestMethod.GET)
	@ResponseBody
	public BankResult datashowbymoney(HttpServletRequest request,HttpSession session,
			@PathVariable("money")String moneytype,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page)
	
			throws Exception{
		int pageNo=page;
		Long fromuser=null;
		Long touser=null;
		String tool=null;
		Integer moneyint = Integer.parseInt(moneytype);
		String fromplace=null;
		Integer safety=null;
		Date date_s=null;
		Date date_e=null;
		Integer safe_action=0;
		List<BankData> datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety,date_s,date_e, safe_action,pageNo, pageSize);
		
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		MyPageList<BankData> list = new MyPageList<>();
		list.setList(datalist);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
		
	}
	
	@RequestMapping(value="/datashowbyfromplace/{fromplace}", method=RequestMethod.GET)
	@ResponseBody
	public BankResult datashowbyfromplace(HttpServletRequest request,HttpSession session,
			@PathVariable("fromplace")String fromplace,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page)
	
			throws Exception{
		int pageNo=page;
		Long fromuser=null;
		Long touser=null;
		Integer moneyint=0;
		String tool=null;
		Integer safety=null;
		Date date_s=null;
		Date date_e=null;
		Integer safe_action=0;
		List<BankData> datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety,date_s,date_e, safe_action,pageNo, pageSize);
		
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		MyPageList<BankData> list = new MyPageList<>();
		list.setList(datalist);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
		
	}
	
	@RequestMapping(value="/datashowbysafety/{safety}", method=RequestMethod.GET)
	@ResponseBody
	public BankResult datashowbysafety(HttpServletRequest request,HttpSession session,
			@PathVariable("safety")String safety,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page)
	
			throws Exception{
		int pageNo=page;
		Long fromuser=null;
		Long touser=null;
		String tool=null;
		Integer safety_t = Integer.parseInt(safety);
		String fromplace=null;
		Integer moneyint=0;
		Date date_s=null;
		Date date_e=null;
		Integer safe_action=0;
		List<BankData> datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety_t,date_s,date_e, safe_action,pageNo, pageSize);
		
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		MyPageList<BankData> list = new MyPageList<>();
		list.setList(datalist);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
		
	}
	
	@RequestMapping(value="/datashowbydate", method=RequestMethod.POST)
	@ResponseBody
	public BankResult datashowbydate(HttpServletRequest request,
			String date_s1,String date_e1,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page)
	
			throws Exception{
		int pageNo=page;
		Long fromuser=null;
		Long touser=null;
		String tool=null;
		Integer moneyint=0;
		String fromplace=null;
		Integer safety=null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
 	    Date date_s=simpleDateFormat.parse(date_s1);
 	    Date date_e=simpleDateFormat.parse(date_e1);
		Integer safe_action=0;
		List<BankData> datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety,date_s,date_e, safe_action,pageNo, pageSize);
		
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		
		MyPageList<BankData> list = new MyPageList<>();
		list.setList(datalist);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
		
	}
	
	@RequestMapping(value="/datashow", method=RequestMethod.POST)
	@ResponseBody
	public BankResult datashow(HttpServletRequest request,HttpSession session,
			Long fromuser,Long touser,String tool,Integer moneyint,String fromplace,Integer safety,String date_s1,String date_e1,Integer safe_action,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page)
	
			throws Exception{
		int pageNo=page;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date_s=null;
		Date date_e=null;
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
		List<BankData> datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety,date_s,date_e, safe_action,pageNo, pageSize);
		List<MyDataList> datalist2 = dataService.showdata(datalist);
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		MyPageList<MyDataList> list = new MyPageList<>();
		list.setList(datalist2);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
		
	}
	
}
