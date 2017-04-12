package com.bankofshanghai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankofshanghai.mypojo.AreaDistribute;
import com.bankofshanghai.mypojo.BankResult;
import com.bankofshanghai.mypojo.BusinessDistribute;
import com.bankofshanghai.mypojo.FraudStatistic;
import com.bankofshanghai.mypojo.MoneyDistribute;
import com.bankofshanghai.mypojo.MyDataList;
import com.bankofshanghai.mypojo.RuleStatistc;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankRule;
import com.bankofshanghai.service.DataService;
import com.bankofshanghai.service.RuleService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/ajax/statistic")
public class StatisticController {

	@Autowired
	private RuleService ruleService;

	@Autowired
	private DataService dataService;

	/*
	 * 规则触发统计
	 */
	@RequestMapping("/rule")
	@ResponseBody
	public BankResult getRuleStatistic() {
		// 规则按触发次数排序
		List<BankRule> rules = ruleService.getRuleList();
		for (int i = 0; i < rules.size(); i++) {
			for (int j = i; j < rules.size(); j++) {
				if (rules.get(i).getFrequency() < rules.get(j).getFrequency()) {
					BankRule temp = rules.get(i);
					rules.set(i, rules.get(j));
					rules.set(j, temp);
				}
			}
		}
		RuleStatistc ruleStatistc = new RuleStatistc();
		ruleStatistc.setRules(rules);
		ruleStatistc.setCount((long) 1000);
		ruleStatistc.setBusinessDistribute(new BusinessDistribute(30, 42, 7, 21));
		return BankResult.ok(ruleStatistc);
	}

	@RequestMapping("/fraud")
	@ResponseBody
	public BankResult getFraudStatistic(@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page) {
		int pageNo = page;
		List<BankData> datalist = dataService.queryByPage(pageNo, pageSize);
		List<MyDataList> datalist2 = dataService.showdata(datalist);
		PageInfo<BankData> pageInfo = new PageInfo<BankData>(datalist);
		FraudStatistic fraud = new FraudStatistic();
		fraud.setData(datalist2);
		fraud.setAreaDistribute(new AreaDistribute(74.1, 8.1, 3.1, 2.3, 1.4, 11.0));
		fraud.setMoneyDistribute(new MoneyDistribute(30.0, 16.0, 18.0, 25.0, 11.0));
		fraud.setBusinessDistribute(new BusinessDistribute(30, 42, 7, 21));
		fraud.setTotal(pageInfo.getTotal());
		return BankResult.ok(fraud);
	}
}
