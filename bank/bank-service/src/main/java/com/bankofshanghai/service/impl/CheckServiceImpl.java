package com.bankofshanghai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.drools.CheckDrools;
import com.bankofshanghai.mapper.DataTriMapper;
import com.bankofshanghai.mapper.PhoneDataMapper;
import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.DataTri;
import com.bankofshanghai.service.CheckService;
import com.bankofshanghai.service.DataService;

@Service
public class CheckServiceImpl implements CheckService {

	@Autowired
	private DataService dataService;
	
	@Autowired
	private DataTriMapper datatrimapper;
	
	@Override
	public int check(BankData data, StatisticsData sData) {
		
		DataTri datatri = datatrimapper.selectByPrimaryKey(data.getId());
		int[] n = new int[13];
		n = CheckDrools.check(data, sData,datatri);
		data.setSafeLevel(n[0]);
		dataService.updateDataSafe(data);
		
		datatri.setTri1(n[1]);
		datatri.setTri2(n[2]);
		datatri.setTri3(n[3]);
		datatri.setTri4(n[4]);
		datatri.setTri5(n[5]);
		datatri.setTri6(n[6]);
		datatri.setTri7(n[7]);
		datatri.setTri8(n[8]);
		datatri.setTri9(n[9]);
		datatri.setTri10(n[10]);
		datatri.setTri11(n[11]);
		datatri.setTri12(n[12]);
		
		datatrimapper.updateByPrimaryKeySelective(datatri);
		
		
		return n[0];
	}

}
