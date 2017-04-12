package com.bankofshanghai.service;

import java.util.Date;
import java.util.List;

import com.bankofshanghai.mypojo.MyDataList;
import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;

public interface DataService {
	BankData getDataByID(Long id);

	boolean updateDataSafe(BankData data);

	List<BankData> queryByPage(Long fromuser, Long touser, Integer moneyint, String fromplace, String tool,
			Integer safety, Date date_s, Date date_e, Integer safe_action, Integer pageNo, Integer pageSize);

	List<BankData> queryByPage(Integer pageNo, Integer pageSize);
	
	List<BankData> select_data(Long fromuser, Long touser, String tool);

	List<MyDataList> showdata(List<BankData> list);
}
