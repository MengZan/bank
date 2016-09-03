package com.bankofshanghai.service;

import java.util.Date;
import java.util.List;

import com.bankofshanghai.pojo.BankUser;

public interface UsermanService {

    BankUser getUserByID(Long userID);
	
	int UsertypeUpdata(Long userID,Integer usertype);
	
	int UserUpdate(BankUser user);
	
	List<BankUser> queryByPage(Integer pageNo,Integer pageSize,Long userid,Integer usertype,Date date_s,Date date_e);
	
	List<BankUser> getUser(Long userid,Integer usertype);
	
}
