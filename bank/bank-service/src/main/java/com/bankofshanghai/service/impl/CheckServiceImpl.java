package com.bankofshanghai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.drools.CheckDrools;
import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.service.CheckService;
import com.bankofshanghai.service.StatisticsService;

@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	private StatisticsService statisticsService;
	
	@Override
	public int check(BankData data) {
		StatisticsData sData = statisticsService.getStatisticData(data);
		CheckDrools drools = new CheckDrools();
		return drools.check(data, sData);
	}
}
