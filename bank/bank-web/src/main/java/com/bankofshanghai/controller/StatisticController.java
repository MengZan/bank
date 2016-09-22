package com.bankofshanghai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankofshanghai.mypojo.BankResult;
import com.bankofshanghai.mypojo.Business;
import com.bankofshanghai.mypojo.RuleStatistc;
import com.bankofshanghai.pojo.BankRule;
import com.bankofshanghai.service.RuleService;

@Controller
@RequestMapping("/ajax/statistic")
public class StatisticController {

	@Autowired
	private RuleService ruleService;

	/*
	 * 规则触发统计
	 */
	@RequestMapping("/rule")
	@ResponseBody
	public BankResult getRuleStatistic() {
		//规则按触发次数排序
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
		ruleStatistc.setBusiness(new Business(30, 42, 7,21));
		return BankResult.ok(ruleStatistc);
	}
}
