package com.bankofshanghai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.mapper.BankRuleMapper;
import com.bankofshanghai.pojo.BankRule;
import com.bankofshanghai.pojo.BankRuleExample;
import com.bankofshanghai.pojo.BankRuleExample.Criteria;
import com.bankofshanghai.service.RuleService;
import com.github.pagehelper.PageHelper;

@Service
public class RuleServiceImpl implements RuleService {

	@Autowired
	private BankRuleMapper ruleMapper;
	
	@Override
	public List<BankRule> getRuleList() {
		BankRuleExample example = new BankRuleExample();
		Criteria criteria =  example.createCriteria();
		criteria.andIdIsNotNull();
		List<BankRule> list = ruleMapper.selectByExample(example);
		return list;
	}

	@Override
	public BankRule getRuleById(Long id) {
		BankRule rule = ruleMapper.selectByPrimaryKey(id);
		return rule;
	}

	@Override
	public boolean updateRule(BankRule rule) {
//		rule.setFrequency((long)0);
		if(ruleMapper.updateByPrimaryKeySelective(rule)>0)
			return true;
		return false;
	}

	@Override
	public boolean addRule(BankRule rule) {
//		rule.setFrequency((long)0);
		if(ruleMapper.insertSelective(rule)>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteRule(Long id) {
		if(ruleMapper.deleteByPrimaryKey(id)>0)
			return true;
		return false;
	}

	@Override
	public List<BankRule> queryByPage(String type, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;

		BankRuleExample example = new BankRuleExample();
		Criteria criteria = example.createCriteria();

		if (type != null) {
			criteria.andTypeEqualTo(type);
		}
		PageHelper.startPage(pageNo, pageSize);
		List<BankRule> list = ruleMapper.selectByExample(example);

		return list;
	}

}