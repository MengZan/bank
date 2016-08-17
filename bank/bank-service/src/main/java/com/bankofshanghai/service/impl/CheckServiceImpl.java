package com.bankofshanghai.service.impl;

import org.springframework.stereotype.Service;

import com.bankofshanghai.drools.CheckDrools;
import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.service.CheckService;

@Service
public class CheckServiceImpl implements CheckService {

	@Override
	public int check(BankData data, StatisticsData sData) {
		return CheckDrools.check(data, sData);
	}

}
