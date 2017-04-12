package com.bankofshanghai.service;

import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;

public interface StatisticsService {

	StatisticsData getStatisticData(BankData data);

}
