package com.bankofshanghai.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankofshanghai.mypojo.BankResult;
import com.bankofshanghai.mypojo.MyPageList;
import com.bankofshanghai.mypojo.OtherBankData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.service.DataService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/ajax/data")
public class OtherController {
	
	@Autowired
	private DataService dataService;
	
	@RequestMapping(value="/bank" , method=RequestMethod.GET)
	@ResponseBody
	public BankResult getDataFromBankofshanghai(@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page) {
		int pageNo = page;
		List<BankData> datalist = dataService.queryByPage(null, null, null, null, null, null, null, null, null, pageNo,pageSize);
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		MyPageList<BankData> list = new MyPageList<>();
		list.setList(datalist);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
	}
	
	@RequestMapping(value="/otherbank" , method=RequestMethod.GET)
	@ResponseBody
	public BankResult getDataFromOtherBank(@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page) {
		int pageNo = page;
		List<BankData> datalist = dataService.queryByPage(null, null, null, null, null, null, null, null, null, pageNo,pageSize);
		List<OtherBankData> others = new ArrayList<>();
		for(BankData data: datalist){
			Random random = new Random();
			int n = random.nextInt(4)+1;
			OtherBankData other = new OtherBankData();
			other.setBankData(data);
			other.setFromBank(n);
			others.add(other);
		}
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		MyPageList<OtherBankData> list = new MyPageList<>();
		list.setList(others);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
	}
}
