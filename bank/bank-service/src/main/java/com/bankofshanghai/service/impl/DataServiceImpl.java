package com.bankofshanghai.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.mapper.BankDataMapper;
import com.bankofshanghai.mapper.BankUserMapper;
import com.bankofshanghai.mapper.DataTriMapper;
import com.bankofshanghai.mypojo.MyDataList;
import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankDataExample;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.pojo.BankUserExample;
import com.bankofshanghai.pojo.DataTri;
import com.bankofshanghai.pojo.DataTriExample;
import com.bankofshanghai.pojo.BankDataExample.Criteria;
import com.bankofshanghai.service.DataService;
import com.github.pagehelper.PageHelper;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private BankDataMapper dataMapper;
	
	@Autowired
	private DataTriMapper datatriMapper;
	
	@Autowired
	private BankUserMapper userMapper;

	@Override
	public BankData getDataByID(Long id) {
		BankData data = dataMapper.selectByPrimaryKey(id);
		return data;
	}

	@Override
	public int updateDataSafe(BankData data) {
		dataMapper.updateByPrimaryKeySelective(data);

		return 1;
	}

	@Override
	public List<BankData> queryByPage(Long fromuser, Long touser, Integer moneyint,String fromplace, String tool,Integer safety,Date date_s,Date date_e, Integer safe_action,Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;

		BankDataExample example = new BankDataExample();
		Criteria criteria = example.createCriteria();
		
		

		if (fromuser != null) {
			criteria.andFromuserEqualTo(fromuser);
		}

		if (touser != null) {
			criteria.andTouserEqualTo(touser);
		}
		
		if(fromplace!=null){
			criteria.andFromplaceEqualTo(fromplace);
		}
		
		if(moneyint==1){
			criteria.andMoneyBetween(new BigDecimal(0), new BigDecimal(5000));
		}
		
		if(moneyint==2){
			criteria.andMoneyBetween(new BigDecimal(5000), new BigDecimal(10000));
		}
		
		if(moneyint==3){
			criteria.andMoneyBetween(new BigDecimal(10000), new BigDecimal(20000));
		}
		
		if(moneyint==4){
			criteria.andMoneyBetween(new BigDecimal(20000), new BigDecimal(50000));
		}
		
		if(moneyint==5){
			criteria.andMoneyGreaterThanOrEqualTo(new BigDecimal(50000));
		}

		if (tool != null) {
			criteria.andToolEqualTo(tool);
		}
		
		if (safety != null && safe_action!=null) {
			if(safe_action==1)criteria.andSafeLevelLessThan(safety);
			if(safe_action==2)criteria.andSafeLevelLessThanOrEqualTo(safety);
			if(safe_action==3)criteria.andSafeLevelEqualTo(safety);
			if(safe_action==4)criteria.andSafeLevelGreaterThanOrEqualTo(safety);
			if(safe_action==5)criteria.andSafeLevelGreaterThanOrEqualTo(safety);
			if(safe_action==6)criteria.andSafeLevelNotEqualTo(safety);
		}
		
		if(date_s!=null &&date_e!=null){
			criteria.andDatetimeBetween(date_s, date_e);
		}
		
		example.setOrderByClause("datetime desc");
		
		PageHelper.startPage(pageNo, pageSize);
		List<BankData> list = dataMapper.selectByExample(example);

		return list;
	}
	
	@Override
	public List<BankData> select_data(Long fromuser, Long touser, String tool){
		
		BankDataExample example = new BankDataExample();
		Criteria criteria = example.createCriteria();
		
		if (fromuser != null) {
			criteria.andFromuserEqualTo(fromuser);
		}

		if (touser != null) {
			criteria.andTouserEqualTo(touser);
		}

		if (tool != null) {
			criteria.andToolEqualTo(tool);
		}
		
		example.setOrderByClause("datetime desc");
		
		List<BankData> list = dataMapper.selectByExample(example);

		return list;
		
	}
	
	@Override
	public List<MyDataList> showdata(List<BankData> list){
		List<MyDataList> datalist = new ArrayList<>();
		int n = list.size();
		for(int i=0;i<n;i++){

			BankUserExample example1 = new BankUserExample();
			BankUserExample example2 = new BankUserExample();
			BankUserExample.Criteria criteria1 = example1.createCriteria();
			BankUserExample.Criteria criteria2 = example2.createCriteria();
			MyDataList mydata = new MyDataList();
			BankData data=list.get(i);
			mydata.setFromplace(data.getFromplace());
			mydata.setFromuser(data.getFromuser());
			mydata.setId(data.getId());
			mydata.setMoney(data.getMoney());
			mydata.setSafeLevel(data.getSafeLevel());
			mydata.setTool(data.getTool());
			mydata.setToplace(data.getToplace());
			mydata.setTouser(data.getTouser());
			mydata.setDatetime(data.getDatetime());
			
			Long fromuser = data.getFromuser();
			criteria1.andIdEqualTo(fromuser);
			List<BankUser> userlist1=userMapper.selectByExample(example1);
			mydata.setFromusername(userlist1.get(0).getUsername());
			
			Long touser = data.getTouser();
			criteria2.andIdEqualTo(touser);
			List<BankUser> userlist2=userMapper.selectByExample(example2);
			mydata.settousername(userlist2.get(0).getUsername());
			datalist.add(mydata);
		}
		
		return datalist;
	}
	
	@Override
	public List<DataTri> selectDataTri(Long id,Integer tri1,Integer tri2,Integer tri3,Integer tri4,Integer tri5,
			Integer tri6,Integer tri7,Integer tri8,Integer tri9,Integer tri10,Integer tri11,Integer tri12)
	{
		DataTriExample example = new DataTriExample();
		DataTriExample.Criteria criteria =example.createCriteria();
		
		if(id!=null) criteria.andIdEqualTo(id);
		if(tri1!=null) criteria.andTri1EqualTo(tri1);
		if(tri2!=null) criteria.andTri2EqualTo(tri2);
		if(tri3!=null) criteria.andTri3EqualTo(tri3);
		if(tri4!=null) criteria.andTri4EqualTo(tri4);
		if(tri5!=null) criteria.andTri5EqualTo(tri5);
		if(tri6!=null) criteria.andTri6EqualTo(tri6);
		if(tri7!=null) criteria.andTri7EqualTo(tri7);
		if(tri8!=null) criteria.andTri8EqualTo(tri8);
		if(tri9!=null) criteria.andTri9EqualTo(tri9);
		if(tri10!=null) criteria.andTri10EqualTo(tri10);
		if(tri11!=null) criteria.andTri11EqualTo(tri11);
		if(tri12!=null) criteria.andTri12EqualTo(tri12);
		
		List<DataTri> list = datatriMapper.selectByExample(example);
		
		return list;
	}

	/**
	 * 获取统计量
	 */
	@Override
	public StatisticsData getStatisticsDataByUser(BankData data) {
		// 查询数据库
		StatisticsData sData = new StatisticsData();
		BankDataExample example = new BankDataExample();
		Criteria criteria = example.createCriteria();
		criteria.andFromuserEqualTo(data.getFromuser());
		List<BankData> list = dataMapper.selectByExample(example);

		// 设置数据总数量
		sData.setDataNumbers(list.size());

		// 设置dataNumbersWithinTime
		int count = 0;
		for (BankData bankData : list) {
			if (getTimeMinuteDifference(data.getDatetime(), bankData.getDatetime()) <= 30) { // 30应该从规则文件读取
				count++;
			}
		}
		sData.setDataNumbersWithinTime(count);

		// 设置常用转出地址
		sData.setCommonFromPlace(getCommonFromPlace(list));

		// 设置日转账金额
		sData.setMoneyOfDay(getMoneyOfDay(list, data));
		
		//设置当日转出用户数量
		sData.setToUsersOfDay(getToUsersOfDay(list, data));

		return sData;
	}

	/**
	 * 计算当日转出用户
	 * @param list
	 * @param data
	 * @return
	 */
	private int getToUsersOfDay(List<BankData> list, BankData data) {
		Set<Long> toUserSet = new HashSet<>();
		for (BankData bankData : list) {
			if (data.getDatetime().getYear() == bankData.getDatetime().getYear()
					&& data.getDatetime().getMonth() == bankData.getDatetime().getMonth()
					&& data.getDatetime().getDate() == bankData.getDatetime().getDate())
				toUserSet.add(bankData.getTouser());
		}
		toUserSet.add(data.getTouser());
		return toUserSet.size();
	}

	/**
	 * 计算日转账金额
	 * 
	 * @param list
	 * @param data
	 * @return
	 */
	private double getMoneyOfDay(List<BankData> list, BankData data) {
		double count = 0;
		for (BankData bankData : list) {
			// 判断是否同一天
			if (data.getDatetime().getYear() == bankData.getDatetime().getYear()
					&& data.getDatetime().getMonth() == bankData.getDatetime().getMonth()
					&& data.getDatetime().getDate() == bankData.getDatetime().getDate())
				count += bankData.getMoney().doubleValue();
		}
		// 加上当次转账金额
		//count += data.getMoney().doubleValue();
		return count;
	}

	/**
	 * 计算时间差
	 * 
	 * @param date1
	 * @param date2
	 * @return 返回分钟数
	 */
	private int getTimeMinuteDifference(Date date1, Date date2) {
		long temp = Math.abs(date2.getTime() - date1.getTime()); // 相差毫秒数
		int mins = (int) temp / 1000 / 60; // 相差分钟数
		return mins;
	}

	/**
	 * 获取常用转出地址
	 * 
	 * @param datas
	 * @return
	 */
	private String getCommonFromPlace(List<BankData> datas) {
		// String str1;
		// String regex;
		// Pattern p;
		// Matcher m;
		// List<String> list = new ArrayList();
		// int n = datas.size();
		// for(int i = 0;i<n;i++)
		// {
		// BankData data=datas.get(i);
		// list.add(data.getFromplace());
		// }
		// String tmp = "";
		// String tot_str = list.toString();
		// int max_cnt = 0;
		// String max_str = "";
		// for(String str11 : list) {
		// if (tmp.equals(str11)) continue;
		// tmp = str11;
		// regex = str11;
		// p = Pattern.compile(regex);
		// m = p.matcher(tot_str);
		// int cnt = 0;
		// while(m.find()) {
		// cnt++;
		// }
		// //System.out.println(str + ":" + cnt);
		// if (cnt > max_cnt) {
		// max_cnt = cnt;
		// max_str = str11;
		// }
		// }
		// System.out.println("字符串 " + max_str );
		return "中国上海上海";
	}

}
