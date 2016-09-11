package com.bankofshanghai.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankofshanghai.mapper.IpAddressMapper;
import com.bankofshanghai.mapper.PhoneDataMapper;
import com.bankofshanghai.pojo.IpAddress;
import com.bankofshanghai.pojo.IpAddressExample;
import com.bankofshanghai.pojo.IpAddressExample.Criteria;
import com.bankofshanghai.pojo.PhoneData;
import com.bankofshanghai.pojo.PhoneDataExample;
import com.bankofshanghai.service.ListService;
import com.github.pagehelper.PageHelper;

@Service
public class ListServiceImpl implements ListService {

	@Autowired
	private IpAddressMapper ipmapper;
	
	@Autowired
	private PhoneDataMapper phonemapper;
	
	@Override
	public IpAddress getIpById(Long id){
		IpAddress ipdata = ipmapper.selectByPrimaryKey(id);
		return ipdata;
		
		
	}
	
	@Override
	public List<IpAddress> queryByPage_ip(Integer pageNo,Integer pageSize,Long id , String ipdata,Integer ipsafe,Date date1,Date date2){
		
	    pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    IpAddressExample example = new IpAddressExample();
	    Criteria criteria = example.createCriteria();
	    
	    if(id!=null) criteria.andIdEqualTo(id);
	    
	    if(ipdata!=null) criteria.andIpEqualTo(ipdata);
	    
	    if(ipsafe!=null) criteria.andSafetyEqualTo(ipsafe);
	    
	    if(date1!=null && date2!=null)criteria.andDatetimeBetween(date1, date2);
	    PageHelper.startPage(pageNo, pageSize);
	    List<IpAddress> list = ipmapper.selectByExample(example);
	    
	    return list;
		
	}
	
	@Override
	public List<IpAddress> select_ip(Long id , String ipdata,Integer ipsafe,Date date1,Date date2){
		IpAddressExample example = new IpAddressExample();
	    Criteria criteria = example.createCriteria();
		
	    if(id!=null) criteria.andIdEqualTo(id);
	    
	    if(ipdata!=null) criteria.andIpEqualTo(ipdata);
	    
	    if(ipsafe!=null) criteria.andSafetyEqualTo(ipsafe);
	    

	    if(date1!=null && date2!=null)criteria.andDatetimeBetween(date1, date2);
	    
        List<IpAddress> list = ipmapper.selectByExample(example);
	    
	    return list;
	}
	
	@Override
	public int updateIp(IpAddress ipdata){
		
		if(ipmapper.updateByPrimaryKeySelective(ipdata)>0)
		    return 1;
		
		return 0;
	}
	
	@Override
	public int addIp(IpAddress ipdata){
		
		if(ipmapper.insertSelective(ipdata)>0)
		return 1;
		
		return 0;
	}
	
	@Override
	public int deleteIp(IpAddress ipdata){
		
		if(ipmapper.deleteByPrimaryKey(ipdata.getId())>0)
		return 1;
		
		return 0;
	}

	@Override
	public PhoneData getPhoneById(Long id){
		
		PhoneData phonedata = phonemapper.selectByPrimaryKey(id);
		return phonedata;
	}
	
	@Override
	public List<PhoneData> queryByPage_phone(Integer pageNo,Integer pageSize,Long id , Integer phonedata , Integer phonesafe,Date date1,Date date2){
		
	    pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PhoneDataExample example = new PhoneDataExample();
	    PhoneDataExample.Criteria criteria = example.createCriteria();
	    
	    if(id!=null) criteria.andIdEqualTo(id);
	    
	    if(phonedata!=null) criteria.andPhoneNumberEqualTo(phonedata);
	    
	    if(phonesafe!=null) criteria.andSafetyEqualTo(phonesafe);
	    

	    if(date1!=null && date2!=null)criteria.andDatetimeBetween(date1, date2);
	    PageHelper.startPage(pageNo, pageSize);
	    List<PhoneData> list = phonemapper.selectByExample(example);
	    
	    return list;
		
	}
	
	@Override
	public List<PhoneData> select_phone(Long id , Integer phonedata , Integer phonesafe,Date date1,Date date2){
	    PhoneDataExample example = new PhoneDataExample();
	    PhoneDataExample.Criteria criteria = example.createCriteria();
	    
	    if(id!=null) criteria.andIdEqualTo(id);
	    
	    if(phonedata!=null) criteria.andPhoneNumberEqualTo(phonedata);
	    
	    if(phonesafe!=null) criteria.andSafetyEqualTo(phonesafe);
	    
	    if(date1!=null && date2!=null)criteria.andDatetimeBetween(date1, date2);
	    
        List<PhoneData> list = phonemapper.selectByExample(example);
	    
	    return list;
		
	}
	
	@Override
	public int updatePhone(PhoneData phonedata){
		
		if(phonemapper.updateByPrimaryKeySelective(phonedata)>0)
		return 1;
		
		return 0;
	}
	
	@Override
	public int addPhone(PhoneData phonedata){
		
		if(phonemapper.insertSelective(phonedata)>0)
		return 1;
		
		return 0;
	}
	
	@Override
	public int deletePhone(PhoneData phonedata){
		
		if(phonemapper.deleteByPrimaryKey(phonedata.getId())>0)
		return 1;
		
		return 0;
	}
	
	@Override
	 public String longToIP(Integer ipdata) {  
	        StringBuffer sb = new StringBuffer("");  
	        // 直接右移24位  
	        sb.append(String.valueOf((ipdata >>> 24)));  
	        sb.append(".");  
	        // 将高8位置0，然后右移16位  
	        sb.append(String.valueOf((ipdata & 0x00FFFFFF) >>> 16));  
	        sb.append(".");  
	        // 将高16位置0，然后右移8位  
	        sb.append(String.valueOf((ipdata & 0x0000FFFF) >>> 8));  
	        sb.append(".");  
	        // 将高24位置0  
	        sb.append(String.valueOf((ipdata & 0x000000FF)));  
	        return sb.toString();  
	    }  
	
}
