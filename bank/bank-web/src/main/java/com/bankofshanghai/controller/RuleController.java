package com.bankofshanghai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankofshanghai.mypojo.RuleFactor;
import com.bankofshanghai.pojo.BankRule;
import com.bankofshanghai.service.RuleService;
import com.bankofshanghai.utils.JsonUtils;

@Controller
public class RuleController {

	@Autowired
	private RuleService ruleService;

	@RequestMapping("/rulelist")
	public String getRuleList(Model model) {
		List<BankRule> rules = ruleService.getRuleList();
		model.addAttribute("rules", rules);
		return "ruleList";
	}

	@RequestMapping("/rule/{id}")
	public String getRuleById(@PathVariable("id") Long id, Model model) {
		BankRule rule = ruleService.getRuleById(id);
		model.addAttribute("rule", rule);
		return "rule";
	}

	@RequestMapping("/ruleEdit")
	public String editRule(BankRule rule, RuleFactor factor) {
		rule.setRuledesc(JsonUtils.objectToJson(factor));
		if (ruleService.updateRuleDesc(rule))
			return "redirect:/rulelist";
		return "error";
	}

}
