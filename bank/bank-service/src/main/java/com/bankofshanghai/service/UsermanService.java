package com.bankofshanghai.service;

import java.util.List;

import com.bankofshanghai.pojo.BankUser;

public interface UsermanService {

    BankUser getUserByID(Long userID);
	
	int UsertypeUpdata(Long userID,Integer usertype);
	
	List<BankUser> queryByPage(Integer pageNo,Integer pageSize,Long userid,Integer usertype);
	
}
