package com.bankofshanghai.service;

import java.util.List;

import com.bankofshanghai.pojo.BankRule;

public interface RuleService {

	List<BankRule> getRuleList();
	
	List<BankRule> queryByPage(String type, Integer pageNo, Integer pageSize);
	
	BankRule getRuleById(Long id);
	
	boolean updateRule(BankRule rule);
	
	boolean addRule(BankRule rule);
	
	boolean deleteRule(Long id);
}