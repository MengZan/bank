package com.bankofshanghai.mypojo;

import java.util.HashMap;
import java.util.Map;

/**
 * 预匹配规则
 *
 */
public class PreRule {

	public final static Map<String, RulePattern> PRE_RULE = new HashMap<>();

	static {
		// 从配置文件加载预匹配规则
		// ...
	}

	public boolean preCheck(RuleFactor factor) {
		for (String left : PRE_RULE.keySet()) {
			String right = PRE_RULE.get(left).getRight();
			String operator = PRE_RULE.get(left).getOperator();
			if (calculate(left, operator, right)) {
				return true;
			}
		}
		return false;
	}

	private boolean calculate(String left, String operator, String right) {
		switch (operator) {
		case ">":
			return false;
		default:
			break;
		}
		return false;
	}
	
	public static void main(String[] args) {

	}
}
