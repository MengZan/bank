package com.bankofshanghai.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.mapper.BankDataMapper;
import com.bankofshanghai.mapper.BankUserMapper;
import com.bankofshanghai.mypojo.MyDataList;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.BankDataExample;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.pojo.BankUserExample;
import com.bankofshanghai.pojo.BankDataExample.Criteria;
import com.bankofshanghai.service.DataService;
import com.github.pagehelper.PageHelper;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private BankDataMapper dataMapper;

	@Autowired
	private BankUserMapper userMapper;

	@Override
	public BankData getDataByID(Long id) {
		BankData data = dataMapper.selectByPrimaryKey(id);
		return data;
	}

	@Override
	public boolean updateDataSafe(BankData data) {
		dataMapper.updateByPrimaryKeySelective(data);
		return true;
	}

	@Override
	public List<BankData> queryByPage(Long fromuser, Long touser, Integer moneyint, String fromplace, String tool,
			Integer safety, Date date_s, Date date_e, Integer safe_action, Integer pageNo, Integer pageSize) {
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
		if (fromplace != null) {
			criteria.andFromplaceEqualTo(fromplace);
		}
		if (moneyint != null) {
			if (moneyint == 1) {
				criteria.andMoneyBetween(new BigDecimal(0), new BigDecimal(5000));
			}
			if (moneyint == 2) {
				criteria.andMoneyBetween(new BigDecimal(5000), new BigDecimal(10000));
			}
			if (moneyint == 3) {
				criteria.andMoneyBetween(new BigDecimal(10000), new BigDecimal(20000));
			}
			if (moneyint == 4) {
				criteria.andMoneyBetween(new BigDecimal(20000), new BigDecimal(50000));
			}
			if (moneyint == 5) {
				criteria.andMoneyGreaterThanOrEqualTo(new BigDecimal(50000));
			}
		}
		if (tool != null) {
			criteria.andToolEqualTo(tool);
		}
		if (safety != null && safe_action != null) {
			if (safe_action == 1)
				criteria.andSafeLevelLessThan(safety);
			if (safe_action == 2)
				criteria.andSafeLevelLessThanOrEqualTo(safety);
			if (safe_action == 3)
				criteria.andSafeLevelEqualTo(safety);
			if (safe_action == 4)
				criteria.andSafeLevelGreaterThanOrEqualTo(safety);
			if (safe_action == 5)
				criteria.andSafeLevelGreaterThanOrEqualTo(safety);
			if (safe_action == 6)
				criteria.andSafeLevelNotEqualTo(safety);
		}
		if (date_s != null && date_e != null) {
			criteria.andDatetimeBetween(date_s, date_e);
		}
		example.setOrderByClause("datetime desc");
		PageHelper.startPage(pageNo, pageSize);
		List<BankData> list = dataMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<BankData> queryByPage(Integer pageNo, Integer pageSize) {
		return queryByPage(null, null, null, null, null, null, null, null, null, pageNo, pageSize);
	}
	
	@Override
	public List<BankData> select_data(Long fromuser, Long touser, String tool) {

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
	public List<MyDataList> showdata(List<BankData> list) {
		List<MyDataList> datalist = new ArrayList<>();
		int n = list.size();
		for (int i = 0; i < n; i++) {

			BankUserExample example1 = new BankUserExample();
			BankUserExample example2 = new BankUserExample();
			BankUserExample.Criteria criteria1 = example1.createCriteria();
			BankUserExample.Criteria criteria2 = example2.createCriteria();
			MyDataList mydata = new MyDataList();
			BankData data = list.get(i);
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
			List<BankUser> userlist1 = userMapper.selectByExample(example1);
			try{
				mydata.setFromusername(userlist1.get(0).getUsername());
			}catch(Exception e){
				mydata.setFromusername("张三");
			}

			Long touser = data.getTouser();
			criteria2.andIdEqualTo(touser);
			List<BankUser> userlist2 = userMapper.selectByExample(example2);
			try{
				mydata.settousername(userlist2.get(0).getUsername());
			}catch(Exception e){
				mydata.settousername("张三");
			}
			datalist.add(mydata);
		}

		return datalist;
	}
}
