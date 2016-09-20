package com.bankofshanghai.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankofshanghai.mypojo.BankResult;
import com.bankofshanghai.mypojo.MyDataList;
import com.bankofshanghai.mypojo.MyPageList;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.pojo.DataTri;
import com.bankofshanghai.pojo.IpAddress;
import com.bankofshanghai.service.CheckService;
import com.bankofshanghai.service.DataService;
import com.bankofshanghai.service.StatisticsService;
import com.bankofshanghai.service.UsermanService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/ajax")
public class CheckController {

	@Autowired
	private CheckService checkService;
	@Autowired
	private DataService dataService;
	@Autowired
	private UsermanService usermanService;
	
	
	//显示data
	@RequestMapping(value="/checkdata",method=RequestMethod.GET)
	@ResponseBody
	public BankResult checkData(HttpServletRequest request,@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page) 
					throws Exception{
		int pageNo=page;
		Long fromuser=null;
		Long touser=null;
		String tool=null;
		Integer moneyint=0;
		String fromplace=null;
		Integer safety=null;
		Date date_s=null;
		Date date_e=null;
		Integer safe_action=0;
		List<BankData> datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety,date_s,date_e, safe_action,pageNo, pageSize);
		List<MyDataList> datalist2 = dataService.showdata(datalist);
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		
		MyPageList<MyDataList> list = new MyPageList<>();
		list.setList(datalist2);
		list.setTotal(pageInfo.getTotal());
		
		return BankResult.ok(list);
	}

	@RequestMapping(value="/check/{id}",method=RequestMethod.POST)
	@ResponseBody
	public BankResult check(@PathVariable(value="id") Long id, Model model) {
		//开始
		long startTime=System.currentTimeMillis();
		//获得检测结果
		BankData data = dataService.getDataByID(id);
		int result = checkService.check(data, dataService.getStatisticsDataByUser(data));
		if (result == -1)  //检测失败
			//model.addAttribute("message","检测失败");
			return BankResult.build(1, "检测失败");
		else  //成功
			data.setSafeLevel(result);
		//结束
		long endTime=System.currentTimeMillis()-startTime;
		model.addAttribute("time", endTime+"毫秒");
		model.addAttribute("data", data);
		return BankResult.ok(data);
	}
	
	@RequestMapping(value="/check_all",method=RequestMethod.POST)
	@ResponseBody
	public BankResult check_all(HttpServletRequest request, Model model,@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page){
		long startTime=System.currentTimeMillis();
		Long fromuser=null;
		Long touser=null;
		String tool=null;
		Integer moneyint=0;
		String fromplace=null;
		Integer safety=null;
		Date date_s=null;
		Date date_e=null;
		int count=0;
		List<BankData> list_t=dataService.select_data(fromuser, touser, tool);
		int n = list_t.size();
		model.addAttribute("count_n",n);
		for(int i=0;i<n;i++){
			BankData data= list_t.get(i);
			Long userid = (long) data.getFromuser();
			BankUser user = usermanService.getUserByID(userid);
			Integer usertype=user.getUsertype();
			if(usertype==0)//黑名单
			{
				data.setSafeLevel(99);
				dataService.updateDataSafe(data);
			}
			else{
			    
				if(usertype==1)//白名单
				{
					data.setSafeLevel(0);
					dataService.updateDataSafe(data);
				}
				
				else // 灰名单，高风险ip、手机号等
				{
					int result = checkService.check(data, dataService.getStatisticsDataByUser(data));
					if (result == -1)  //检测失败
						return BankResult.build(1, "检测失败");
					else  {//成功
						data.setSafeLevel(result);
						count++;
					}
				}
					
			}
			
		}
		long endTime=System.currentTimeMillis()-startTime;
		model.addAttribute("time", endTime+"毫秒");
		model.addAttribute("count",count);
		Integer safe_action=0;
		List<BankData> datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety,date_s,date_e, safe_action,page, pageSize);
		
		List<MyDataList> datalist2 = dataService.showdata(datalist);
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		
		MyPageList<MyDataList> list = new MyPageList<>();
		list.setList(datalist2);
		list.setTotal(pageInfo.getTotal());
		
		return BankResult.ok(list);
	}
	
	@RequestMapping(value="/check_imm",method=RequestMethod.POST)
	@ResponseBody
	public BankResult check_test(HttpServletRequest request, Model model,
			@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page) {
		
		Long fromuser=null;
		Long touser=null;
		String tool=null;
		Integer moneyint=0;
		String fromplace=null;
		Integer safety=null;
		Date date_s=null;
		Date date_e=null;
		Integer safe_action=0;
		List<BankData> datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety,date_s,date_e, safe_action,page, pageSize);
		
		int n = datalist.size();
		for(int i=0;i<n;i++){
			BankData data= datalist.get(i);
			Long userid = (long) data.getFromuser();
			BankUser user = usermanService.getUserByID(userid);
			Integer usertype=user.getUsertype();
			if(usertype==0)//黑名单
			{
				data.setSafeLevel(99);
				dataService.updateDataSafe(data);
			}
			else{
			    
				if(usertype==1)//白名单
				{
					data.setSafeLevel(0);
					dataService.updateDataSafe(data);
				}
				
				else // 灰名单，高风险ip、手机号等
				{
					int result = checkService.check(data, dataService.getStatisticsDataByUser(data));
					if (result == -1)  //检测失败
						return BankResult.build(1, "检测失败");
					else  {//成功
						data.setSafeLevel(result);
					}
				}
					
			}
			
		}
		
		datalist=dataService.queryByPage(fromuser, touser, moneyint,fromplace, tool,safety,date_s,date_e,safe_action, page, pageSize);
		
		List<MyDataList> datalist2 = dataService.showdata(datalist);
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		
		MyPageList<MyDataList> list = new MyPageList<>();
		list.setList(datalist2);
		list.setTotal(pageInfo.getTotal());
		
		return BankResult.ok(list);
	}
}
