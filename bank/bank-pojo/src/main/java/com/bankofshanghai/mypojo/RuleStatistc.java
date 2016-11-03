package com.bankofshanghai.mypojo;

import java.util.List;

import com.bankofshanghai.pojo.BankRule;

/**
 * 规则触发统计
 * 
 * @author DMM
 *
 */
public class RuleStatistc {

	private List<BankRule> rules;

	private BusinessDistribute businessDistribute;

	private Long count;

	public List<BankRule> getRules() {
		return rules;
	}

	public void setRules(List<BankRule> rules) {
		this.rules = rules;
	}

	public BusinessDistribute getBusinessDistribute() {
		return businessDistribute;
	}

	public void setBusinessDistribute(BusinessDistribute businessDistribute) {
		this.businessDistribute = businessDistribute;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
