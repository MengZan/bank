package com.bankofshanghai.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.service.CheckService;
import com.bankofshanghai.service.DataService;
import com.bankofshanghai.service.UsermanService;

@Controller
public class CheckController {

	@Autowired
	private CheckService checkService;
	@Autowired
	private DataService dataService;
	@Autowired
	private UsermanService usermanService;
	
	
	@RequestMapping("/checkdata")
	public String checkData() {
		return "checkData";
	}

	@RequestMapping("/check")
	public String check(BankData data, Model model) {
		//开始
		long startTime=System.currentTimeMillis();
		//获得检测结果
		int result = checkService.check(data, dataService.getStatisticsDataByUser(data));
		if (result == -1)  //检测失败
			model.addAttribute("message","检测失败");
		else  //成功
			data.setSafeLevel(result);
		//结束
		long endTime=System.currentTimeMillis()-startTime;
		model.addAttribute("time", endTime+"毫秒");
		model.addAttribute("data", data);
		return "checkData";
	}
	
	@RequestMapping("/check_test")
	public String check_test(HttpServletRequest request, Model model,
			@RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos) {
		
		Integer fromuser=null;
		Integer touser=null;
		String tool=null;
		List<BankData> list=dataService.queryByPage(fromuser, touser, tool, pageNos, rows);
		
		int n = list.size();
		for(int i=0;i<n;i++){
			BankData data= list.get(i);
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
						model.addAttribute("message","检测失败");
					else  //成功
						data.setSafeLevel(result);
					model.addAttribute("data", data);
				}
					
			}
			
		}
		
		return "checkData";
	}
}
