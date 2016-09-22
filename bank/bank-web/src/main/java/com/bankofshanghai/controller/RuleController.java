package com.bankofshanghai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bankofshanghai.mypojo.BankResult;
import com.bankofshanghai.mypojo.MyBankRule;
import com.bankofshanghai.mypojo.MyPageList;
import com.bankofshanghai.mypojo.RuleFactor;
import com.bankofshanghai.pojo.BankRule;
import com.bankofshanghai.service.RuleService;
import com.bankofshanghai.utils.JsonUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/ajax")
public class RuleController {

	@Autowired
	private RuleService ruleService;

	/**
	 * 查看规则列表
	 * @param pageSize 每页多少条数据
	 * @param page 当前页
	 * @param type 规则类型
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/rules", method=RequestMethod.GET)
	@ResponseBody
	public BankResult getRuleList(@RequestParam(required = false, defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false) String type) throws Exception {
		if (type != null && !"".equals(type)) {
			type=new String(type.getBytes("iso8859-1"),"utf-8");
		}
		List<BankRule> rules = ruleService.queryByPage(type, page, pageSize);
		PageInfo<BankRule> pageInfo = new PageInfo<BankRule>(rules);
		
		//带分页信息的集合
		MyPageList<BankRule> list = new MyPageList<>();
		list.setList(rules);
		list.setTotal(pageInfo.getTotal());
		return BankResult.ok(list);
	}

	/**
	 * 添加规则
	 * @param rule
	 * @param factor
	 * @return
	 */
	@RequestMapping(value="/rules", method=RequestMethod.POST)
	@ResponseBody
	public BankResult addRule(BankRule rule, RuleFactor factor) {
		rule.setRuledesc(JsonUtils.objectToJson(factor));
		if (ruleService.addRule(rule))
			return BankResult.ok();
		return BankResult.build(1, "添加失败");
	}
	
	/**
	 * 通过ID查看规则
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/rules/{id}" , method=RequestMethod.GET)
	@ResponseBody
	public BankResult getRuleById(@PathVariable("id") String id) {
		BankRule rule = ruleService.getRuleById(id);
		MyBankRule myBankRule = new MyBankRule(rule);
		return BankResult.ok(myBankRule);
	}

	/**
	 * 修改规则
	 * @param id
	 * @param rule
	 * @param factor
	 * @return
	 */
	@RequestMapping(value="/rules/{id}" , method=RequestMethod.POST)
	@ResponseBody
	public BankResult editRule(@PathVariable(value="id") String id, BankRule rule, RuleFactor factor) {
		rule.setId(id);
		rule.setRuledesc(JsonUtils.objectToJson(factor));
		if (ruleService.updateRule(rule))
			return BankResult.ok();
		return BankResult.build(1, "更新失败");
	}

	/**
	 * 删除规则
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/rules/{id}" , method=RequestMethod.DELETE)
	@ResponseBody
	public BankResult deleteRule(@PathVariable(value="id") String id) {
		ruleService.deleteRule(id);
		return BankResult.ok();
	}

}