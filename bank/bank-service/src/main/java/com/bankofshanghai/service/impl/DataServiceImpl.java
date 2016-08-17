package com.bankofshanghai.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.mapper.BankDataMapper;
import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankDataExample;
import com.bankofshanghai.pojo.BankDataExample.Criteria;
import com.bankofshanghai.service.DataService;

@Service
public class DataServiceImpl implements DataService{

	@Autowired
	private BankDataMapper dataMapper;
	
	@Override
	public StatisticsData getStatisticsDataByUser(BankData data) {
	 	StatisticsData sData = new StatisticsData();
		BankDataExample example = new BankDataExample();
		Criteria criteria =  example.createCriteria();
		criteria.andFromuserEqualTo(data.getFromuser());
		List<BankData> list = dataMapper.selectByExample(example);
		
		//获得数据数量
		sData.setDataNumbers(list.size());
		
		//计算时间差之内的数据数量
		int count = 0;
		for(BankData bankData : list){
			if(getTimeMinuteDifference(data.getDatetime(), bankData.getDatetime())<=30){
				count++;
			}
		}
		sData.setDataNumbersFromTime(count);
		
		//获得常用转出地址
		sData.setCommonFromPlace(getCommonFromPlace(list));
		return sData;
	}
	
	/**
	 * 计算时间差
	 * @param date1
	 * @param date2
	 * @return 返回分钟数
	 */
	public int getTimeMinuteDifference(Date date1, Date date2){
	        long temp = Math.abs(date2.getTime() - date1.getTime());    //相差毫秒数
	        int mins = (int)temp/ 1000 / 60;                    //相差分钟数
	        return mins;
	}
	
	/**
	 * 获取常用转出地址
	 * @param datas
	 * @return
	 */
	public String getCommonFromPlace(List<BankData> datas){
		return "上海";
	}

}
