package com.bankofshanghai.mypojo;

import java.util.ArrayList;
import java.util.List;

import com.bankofshanghai.utils.JsonUtils;

public class RulePattern {
	// 左件
	private String left;
	// 运算符
	private String operator;
	// 右件
	private String right;
	// 与前一个模式的连接符
	private String unionWithPrePattern;

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public String getUnionWithPrePattern() {
		return unionWithPrePattern;
	}

	public void setUnionWithPrePattern(String unionWithPrePattern) {
		this.unionWithPrePattern = unionWithPrePattern;
	}
	
	public static void main(String[] args) {
		RulePattern p1 = new RulePattern();
		p1.setLeft("money");
		p1.setOperator(">=");
		p1.setRight("500");
		p1.setUnionWithPrePattern("&");
		RulePattern p2 = new RulePattern();
		p2.setLeft("fromplace");
		p2.setOperator("!=");
		p2.setRight("commonFromPlace");
		p2.setUnionWithPrePattern("&");
		List<RulePattern> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		System.out.println(JsonUtils.objectToJson(list));
	}
}
