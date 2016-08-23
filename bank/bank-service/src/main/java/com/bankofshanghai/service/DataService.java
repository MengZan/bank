package com.bankofshanghai.service;

import java.util.List;

import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankUser;

public interface DataService {
	StatisticsData getStatisticsDataByUser(BankData data);
	
	BankData getDataByID(Long id);
	
	int updateDataSafe(BankData data);

	List<BankData> queryByPage(Long fromuser, Long touser, String tool, Integer pageNo, Integer pageSize);
}
