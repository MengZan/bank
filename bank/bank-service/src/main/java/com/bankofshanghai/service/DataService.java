package com.bankofshanghai.service;

import java.util.Date;
import java.util.List;

import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.pojo.DataTri;

public interface DataService {
	StatisticsData getStatisticsDataByUser(BankData data);
	
	BankData getDataByID(Long id);
	
	int updateDataSafe(BankData data);

	List<BankData> queryByPage(Long fromuser, Long touser, Integer moneyint,String fromplace,String tool,Integer safety,Date date_s,Date date_e,Integer safe_action, Integer pageNo, Integer pageSize);
	
	List<BankData> select_data(Long fromuser, Long touser, String tool);
	
	List<DataTri> selectDataTri(Long id,Integer tri1,Integer tri2,Integer tri3,Integer tri4,Integer tri5,
			Integer tri6,Integer tri7,Integer tri8,Integer tri9,Integer tri10,Integer tri11,Integer tri12);
}
