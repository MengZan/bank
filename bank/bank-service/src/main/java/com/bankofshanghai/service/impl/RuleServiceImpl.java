package com.bankofshanghai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.mapper.BankRuleMapper;
import com.bankofshanghai.mypojo.RuleFactor;
import com.bankofshanghai.mypojo.RulePattern;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankRule;
import com.bankofshanghai.pojo.BankRuleExample;
import com.bankofshanghai.pojo.BankRuleExample.Criteria;
import com.bankofshanghai.service.RuleService;
import com.bankofshanghai.utils.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

@Service
public class RuleServiceImpl implements RuleService {

	@Autowired
	private BankRuleMapper ruleMapper;

	@Override
	public List<BankRule> getRuleList() {
		BankRuleExample example = new BankRuleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIsNotNull();
		List<BankRule> list = ruleMapper.selectByExample(example);
		return list;
	}

	@Override
	public BankRule getRuleById(String id) {
		BankRule rule = ruleMapper.selectByPrimaryKey(id);
		return rule;
	}

	@Override
	public boolean updateRule(BankRule rule) {
		if (ruleMapper.updateByPrimaryKeySelective(rule) > 0)
			return true;
		return false;
	}

	@Override
	public boolean addRule(BankRule rule) {
		if (ruleMapper.insertSelective(rule) > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteRule(String id) {
		if (ruleMapper.deleteByPrimaryKey(id) > 0)
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

	@Override
	public String ruleTranslate(BankRule rule) {
		List<RulePattern> patterns = JsonUtils.jsonToList(rule.getRuledesc(), RulePattern.class);
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append("rule " + "\"" + rule.getRulename() + "\"");
		sbuilder.append('\n');
		sbuilder.append("when");
		sbuilder.append('\n');
		sbuilder.append("  $factor:RuleFactor(");
		for (int i = 0; i < patterns.size(); i++) {
			if (i != 0) {
				sbuilder.append(patterns.get(i).getUnionWithPrePattern());
			}
			String left = patterns.get(i).getLeft();
			String right = patterns.get(i).getRight();
			String operator = patterns.get(i).getOperator();
			if (RuleFactor.TRANSACTION_DATA.contains(left)) {
				sbuilder.append("data." + left);
			} else if (RuleFactor.STATISTICS_DATA.contains(left)) {
				sbuilder.append("sData." + left);
			} else {
				throw new RuntimeException("Error:");
			}
			sbuilder.append(operator);
			if (RuleFactor.TRANSACTION_DATA.contains(right)) {
				sbuilder.append("data." + right);
			} else if (RuleFactor.STATISTICS_DATA.contains(right)) {
				sbuilder.append("sData." + right);
			} else {
				sbuilder.append(right);
			}
			sbuilder.append(")");
		}
		sbuilder.append('\n');
		sbuilder.append("then");
		sbuilder.append('\n');
		sbuilder.append("  $factor.data.setSafeLevel($factor.data.getSafeLevel()+"+rule.getSafeLevel()+")");
		sbuilder.append('\n');
		sbuilder.append("end");
		return sbuilder.toString();
	}

	public static void main(String[] args) {
		RuleService service = new RuleServiceImpl();
		BankRule rule = new BankRule();
		rule.setRulename("Rule1");
		rule.setRuledesc("[{\"left\":\"money\",\"operator\":\">=\",\"right\":\"500\",\"unionWithPrePattern\":\"&\"},{\"left\":\"fromplace\",\"operator\":\"!=\",\"right\":\"commonFromPlace\",\"unionWithPrePattern\":\"&\"}]");
		rule.setSafeLevel(30);
		System.out.println(service.ruleTranslate(rule));
	}
}