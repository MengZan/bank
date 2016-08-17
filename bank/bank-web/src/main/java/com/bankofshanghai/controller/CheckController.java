package com.bankofshanghai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.service.CheckService;
import com.bankofshanghai.service.DataService;

@Controller
public class CheckController {

	@Autowired
	private CheckService checkService;
	@Autowired
	private DataService dataService;

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
}
