package com.bankofshanghai.service;

import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;

public interface CheckService {

	/**
	 * 
	 * @param data 检测数据
	 * @param userDatas 该用户的历史数据
	 * @return -1：检测失败；0：无风险；1-5：风险等级
	 */
	int check(BankData data, StatisticsData sData);
}
