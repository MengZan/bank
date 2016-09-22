package com.bankofshanghai.mypojo;

import java.util.List;

import com.bankofshanghai.pojo.BankRule;

/**
 * 规则触发统计
 * @author DMM
 *
 */
public class RuleStatistc {

	private  List<BankRule> rules;
	
	private Business business;
	
	private Long count;

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<BankRule> getRules() {
		return rules;
	}

	public void setRules(List<BankRule> rules) {
		this.rules = rules;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}
	
}
