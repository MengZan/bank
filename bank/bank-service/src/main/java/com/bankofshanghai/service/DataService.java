package com.bankofshanghai.service;

import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;

public interface DataService {
	StatisticsData getStatisticsDataByUser(BankData data);
}
