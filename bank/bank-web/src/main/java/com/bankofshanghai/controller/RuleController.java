package com.bankofshanghai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankofshanghai.mypojo.RuleFactor;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankRule;
import com.bankofshanghai.service.RuleService;
import com.bankofshanghai.utils.JsonUtils;
import com.github.pagehelper.PageInfo;

@Controller
public class RuleController {

	@Autowired
	private RuleService ruleService;

	/**
	 * 规则列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/rulelist")
	public String getRuleList(Model model, @RequestParam(required = false, defaultValue = "10") int rows,
			@RequestParam(required = false, defaultValue = "1") int pageNos,
			@RequestParam(required = false) String type) throws Exception {
		// List<BankRule> rules = ruleService.getRuleList();
		if (type != null) {
			type=new String(type.getBytes("iso8859-1"),"utf-8");
		}
		List<BankRule> rules = ruleService.queryByPage(type, pageNos, rows);
		model.addAttribute("rules", rules);
		PageInfo<BankRule> pageInfo = new PageInfo<BankRule>(rules);
		model.addAttribute("recordCount", pageInfo.getPages()); // 总页数
		model.addAttribute("pageNos", pageNos); // 页号
		return "ruleList";
	}

	/**
	 * 转到添加规则
	 * 
	 * @return
	 */
	@RequestMapping("rule")
	public String rule() {
		return "rule";
	}

	/**
	 * 转到修改规则
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/rule/{id}")
	public String getRuleById(@PathVariable("id") Long id, Model model) {
		BankRule rule = ruleService.getRuleById(id);
		model.addAttribute("rule", rule);
		// 由json得到RuleFactor对象
		RuleFactor ruleFactor = JsonUtils.jsonToPojo(rule.getRuledesc(), RuleFactor.class);
		model.addAttribute("ruleFactor", ruleFactor);
		return "rule";
	}

	/**
	 * 修改规则
	 * 
	 * @param rule
	 * @param factor
	 * @return
	 */
	@RequestMapping("/editRule")
	public String editRule(BankRule rule, RuleFactor factor) {
		rule.setRuledesc(JsonUtils.objectToJson(factor));
		if (ruleService.updateRule(rule))
			return "redirect:/rulelist";
		return "error";
	}

	/**
	 * 添加规则
	 * 
	 * @param rule
	 * @param factor
	 * @return
	 */
	@RequestMapping("/addRule")
	public String addRule(BankRule rule, RuleFactor factor) {
		rule.setRuledesc(JsonUtils.objectToJson(factor));
		ruleService.addRule(rule);
		return "redirect:/rulelist";
	}

	/**
	 * 删除规则
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteRule/{id}")
	public String deleteRule(@PathVariable("id") Long id) {
		ruleService.deleteRule(id);
		return "redirect:/rulelist";
	}

}