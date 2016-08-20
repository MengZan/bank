package com.bankofshanghai.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.mapper.BankDataMapper;
import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankDataExample;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.pojo.BankDataExample.Criteria;
import com.bankofshanghai.service.DataService;
import com.github.pagehelper.PageHelper;

@Service
public class DataServiceImpl implements DataService{

	@Autowired
	private BankDataMapper dataMapper;
	
	@Override
	public BankData getDataByID(Long id)
	{
		BankData data = dataMapper.selectByPrimaryKey(id);
		return data;
	}
	
	@Override
	public int  updateDataSafe(BankData data)
	{
		dataMapper.updateByPrimaryKeySelective(data);
		
		return 1;
	}
	
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
		String str1;
		String regex;
		Pattern p;
		Matcher m;
		List<String> list = new ArrayList();
		int n = datas.size();
		for(int i = 0;i<n;i++)
		{
			BankData data=datas.get(i);
			list.add(data.getFromplace());
		}
		String tmp = "";		
		String tot_str = list.toString();
		int max_cnt = 0;
		String max_str = "";
		for(String str11 : list) {
			if (tmp.equals(str11)) continue;			
			tmp = str11;
			regex = str11;
			p = Pattern.compile(regex);
			m = p.matcher(tot_str);
			int cnt = 0;
			while(m.find()) {
				cnt++;
			}
			//System.out.println(str + ":" + cnt);
			if (cnt > max_cnt) {
				max_cnt = cnt;
				max_str = str11;
			}
		}	
		System.out.println("字符串 " + max_str );
		return "上海";
	}
	
	@Override
	public List<BankData> queryByPage(Integer fromuser,Integer touser,String tool, Integer pageNo,Integer pageSize) {
	    pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    
	    
		BankDataExample example = new BankDataExample();
		Criteria criteria = example.createCriteria();
		
		if(fromuser!=null){
			criteria.andFromuserEqualTo(fromuser);
			}
			
			if(touser!=null){
			criteria.andTouserEqualTo(touser);
			}
			
			
			
			if(tool!=null){
				criteria.andToolEqualTo(tool);
			}
			PageHelper.startPage(pageNo, pageSize);
			List<BankData> list = dataMapper.selectByExample(example);
			
	    //鐢≒ageInfo瀵圭粨鏋滆繘琛屽寘瑁�
	    //PageInfo<BankData> page = new PageInfo<BankData>(list);
	    //娴嬭瘯PageInfo鍏ㄩ儴灞炴��
	    
	    
	    return list;
	}  

}
