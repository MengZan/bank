package com.bankofshanghai.mypojo;

import com.bankofshanghai.pojo.BankRule;
import com.bankofshanghai.utils.JsonUtils;

/**
 * BankRule的包装类，添加了规则因子
 *
 */
public class MyBankRule {

	private BankRule bankRule;
	
	private RuleFactor ruleFactor;

	public MyBankRule(BankRule rule){
		this.bankRule = rule;
		this.ruleFactor = JsonUtils.jsonToPojo(bankRule.getRuledesc() , RuleFactor.class);
	}

	public BankRule getBankRule() {
		return bankRule;
	}

	public void setBankRule(BankRule bankRule) {
		this.bankRule = bankRule;
	}

	public RuleFactor getRuleFactor() {
		return ruleFactor;
	}
	
}