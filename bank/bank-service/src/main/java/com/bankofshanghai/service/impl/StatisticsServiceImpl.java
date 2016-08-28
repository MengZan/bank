package com.bankofshanghai.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.pojo.DataTri;
import com.bankofshanghai.pojo.IpAddress;
import com.bankofshanghai.pojo.PhoneData;
import com.bankofshanghai.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService{

	@Override
	public int[] count_user(List<BankUser> list){
		int n =list.size();
		int[] result = new int[4];
		for(int i=0;i<n;i++){
			BankUser user = list.get(i);
			if(user.getUsertype()==0) result[0]++;
			if(user.getUsertype()==1) result[1]++;
			if(user.getUsertype()==2) result[2]++;
			if(user.getUsertype()==3) result[3]++;
		}
		return result;
	}
	
	@Override
	public int[] count_ip(List<IpAddress> list){
		int[] result = new int[2];
		int n =list.size();
		for(int i=0;i<n;i++){
			IpAddress ipdata = list.get(i);
			if(ipdata.getSafety()==0) result[0]++;
			if(ipdata.getSafety()==1) result[1]++;
		}
		return result;
	}
	
	@Override
	public int[] count_phone(List<PhoneData> list){
        int[] result = new int[2];
        int n =list.size();
        for(int i=0;i<n;i++){
        	PhoneData phonedata = list.get(i);
			if(phonedata.getSafety()==0) result[0]++;
			if(phonedata.getSafety()==1) result[1]++;
		}
		return result;
	}
	
	@Override
	public int[] count_datatri(List<DataTri> list){
        int[] result = new int[13];
        int n =list.size();
        for(int i=0;i<n;i++){
        	DataTri tridata = list.get(i);
        	if(tridata.getTri1()==1) result[1]++;
        	if(tridata.getTri2()==1) result[2]++;
        	if(tridata.getTri3()==1) result[3]++;
        	if(tridata.getTri4()==1) result[4]++;
        	if(tridata.getTri5()==1) result[5]++;
        	if(tridata.getTri6()==1) result[6]++;
        	if(tridata.getTri7()==1) result[7]++;
        	if(tridata.getTri8()==1) result[8]++;
        	if(tridata.getTri9()==1) result[9]++;
        	if(tridata.getTri10()==1) result[10]++;
        	if(tridata.getTri11()==1) result[11]++;
        	if(tridata.getTri12()==1) result[12]++;
        	
		}
		return result;
	}

	
}
