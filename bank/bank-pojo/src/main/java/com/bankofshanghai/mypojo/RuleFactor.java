package com.bankofshanghai.mypojo;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import com.bankofshanghai.pojo.BankData;

public class RuleFactor {
	
	// 交易数据字段
	public static final Set<String> TRANSACTION_DATA = new HashSet<>();
	// 用户统计量
	public static final Set<String> STATISTICS_DATA = new HashSet<>();

	static {
		for (Field field : BankData.class.getDeclaredFields()) {
			TRANSACTION_DATA.add(field.getName());
		}
		for (Field field : StatisticsData.class.getDeclaredFields()) {
			STATISTICS_DATA.add(field.getName());
		}
	}

	public static void main(String[] args) {
		RuleFactor factor = new RuleFactor();
		System.out.println(RuleFactor.TRANSACTION_DATA.size());
	}
}
