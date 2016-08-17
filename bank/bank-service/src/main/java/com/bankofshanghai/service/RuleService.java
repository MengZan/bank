package com.bankofshanghai.service;

import java.util.List;

import com.bankofshanghai.pojo.BankRule;

public interface RuleService {

	List<BankRule> getRuleList();
	
	BankRule getRuleById(Long id);
	
	boolean updateRuleDesc(BankRule rule);
}
