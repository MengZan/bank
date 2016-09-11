package com.bankofshanghai.service;

import java.util.Date;
import java.util.List;

import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.IpAddress;
import com.bankofshanghai.pojo.PhoneData;

public interface ListService {
	
	IpAddress getIpById(Long id);
	
	List<IpAddress> queryByPage_ip(Integer pageNo,Integer pageSize,Long id , String ipdata,Integer ipsafe,Date date1,Date date2);
	
	List<IpAddress> select_ip(Long id , String ipdata,Integer ipsafe,Date date1,Date date2);
	
	int updateIp(IpAddress ipdata);
	
	int addIp(IpAddress ipdata);
	
	int deleteIp(IpAddress ipdata);

	PhoneData getPhoneById(Long id);
	
	List<PhoneData> queryByPage_phone(Integer pageNo,Integer pageSize,Long id , Integer phonedata , Integer phonesafe,Date date1,Date date2);
	
	List<PhoneData> select_phone(Long id , Integer phonedata , Integer phonesafe,Date date1,Date date2);
	
	int updatePhone(PhoneData phonedata);
	
	int addPhone(PhoneData phonedata);
	
	int deletePhone(PhoneData phonedata);

	String longToIP(Integer ipdata);
	
	
}
