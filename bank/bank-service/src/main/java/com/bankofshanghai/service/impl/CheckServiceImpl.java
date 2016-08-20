package com.bankofshanghai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.drools.CheckDrools;
import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.service.CheckService;
import com.bankofshanghai.service.DataService;

@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	private DataService dataService;
	
	@Override
	public int check(BankData data, StatisticsData sData) {
		
		int n = CheckDrools.check(data, sData);
		data.setSafeLevel(n);
		dataService.updateDataSafe(data);
		return n;
	}

}
