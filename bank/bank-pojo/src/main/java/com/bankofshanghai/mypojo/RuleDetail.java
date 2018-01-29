package com.bankofshanghai.mypojo;

import java.util.List;

import com.bankofshanghai.pojo.BankRule;
import com.bankofshanghai.utils.JsonUtils;

/**
 * BankRule的包装类，添加了规则模式
 *
 */
public class RuleDetail {

	private BankRule bankRule;
	
	private List<RulePattern> patterns;

	public RuleDetail(BankRule rule){
		this.bankRule = rule;
		this.patterns = JsonUtils.jsonToList(rule.getRuledesc(), RulePattern.class);
	}

	public BankRule getBankRule() {
		return bankRule;
	}

	public void setBankRule(BankRule bankRule) {
		this.bankRule = bankRule;
	}

	public List<RulePattern> getPatterns() {
		return patterns;
	}

	public void setPatterns(List<RulePattern> patterns) {
		this.patterns = patterns;
	}
	
}