package com.bankofshanghai.service;

import java.util.List;

import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.pojo.DataTri;
import com.bankofshanghai.pojo.IpAddress;
import com.bankofshanghai.pojo.PhoneData;

public interface StatisticsService {
	
	int[] count_user(List<BankUser> list);
	
	int[] count_ip(List<IpAddress> list);
	
	int[] count_phone(List<PhoneData> list);
	
	int[] count_datatri(List<DataTri> list);

}
