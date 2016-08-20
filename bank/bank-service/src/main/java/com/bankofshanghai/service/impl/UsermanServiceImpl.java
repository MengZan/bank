package com.bankofshanghai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.mapper.BankUserMapper;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.pojo.BankUserExample;
import com.bankofshanghai.pojo.BankUserExample.Criteria;
import com.bankofshanghai.service.UsermanService;
import com.github.pagehelper.PageHelper;

@Service
public class UsermanServiceImpl implements UsermanService {

	@Autowired
	private BankUserMapper userMapper;
	
	@Override
	public BankUser getUserByID(Long userID) {
		BankUser user = userMapper.selectByPrimaryKey(userID);
		return user;
	}

	@Override
	public int UsertypeUpdata(Long userID,Integer usertype){
		BankUser user = new BankUser();
		user.setId(userID);
		user.setUsertype(usertype);
		userMapper.updateByPrimaryKeySelective(user);
		return 1;
	}
	
	@Override
	public List<BankUser> queryByPage(Integer pageNo,Integer pageSize,Long userid,Integer usertype) {
	    pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	
	    BankUserExample example = new BankUserExample();
	    Criteria criteria = example.createCriteria();
	    
	    if(userid!=null)
	    criteria.andIdEqualTo(userid);
	    
	    
	    if(usertype!=7)
	    	criteria.andUsertypeEqualTo(usertype);
	    
	    PageHelper.startPage(pageNo, pageSize);
	    List<BankUser> list=userMapper.selectByExample(example);
	    return list;
	}
	
}
