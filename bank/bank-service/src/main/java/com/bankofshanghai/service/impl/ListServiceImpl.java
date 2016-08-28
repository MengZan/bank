package com.bankofshanghai.service.impl;

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
	public List<IpAddress> queryByPage_ip(Integer pageNo,Integer pageSize,Long id , Integer ipdata,Integer ipsafe){
		
	    pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    IpAddressExample example = new IpAddressExample();
	    Criteria criteria = example.createCriteria();
	    
	    if(id!=null) criteria.andIdEqualTo(id);
	    
	    if(ipdata!=null) criteria.andIpEqualTo(ipdata);
	    
	    if(ipsafe!=null) criteria.andSafetyEqualTo(ipsafe);
	    PageHelper.startPage(pageNo, pageSize);
	    List<IpAddress> list = ipmapper.selectByExample(example);
	    
	    return list;
		
	}
	
	@Override
	public List<IpAddress> select_ip(Long id , Integer ipdata,Integer ipsafe){
		IpAddressExample example = new IpAddressExample();
	    Criteria criteria = example.createCriteria();
		
	    if(id!=null) criteria.andIdEqualTo(id);
	    
	    if(ipdata!=null) criteria.andIpEqualTo(ipdata);
	    
	    if(ipsafe!=null) criteria.andSafetyEqualTo(ipsafe);
	    
        List<IpAddress> list = ipmapper.selectByExample(example);
	    
	    return list;
	}
	
	@Override
	public int updateIp(IpAddress ipdata){
		
		ipmapper.updateByPrimaryKeySelective(ipdata);
		return 1;
	}
	
	@Override
	public int addIp(IpAddress ipdata){
		
		ipmapper.insertSelective(ipdata);
		return 1;
	}
	
	@Override
	public int deleteIp(IpAddress ipdata){
		
		ipmapper.deleteByPrimaryKey(ipdata.getId());
		return 1;
	}

	@Override
	public PhoneData getPhoneById(Long id){
		
		PhoneData phonedata = phonemapper.selectByPrimaryKey(id);
		return phonedata;
	}
	
	@Override
	public List<PhoneData> queryByPage_phone(Integer pageNo,Integer pageSize,Long id , Integer phonedata , Integer phonesafe){
		
	    pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PhoneDataExample example = new PhoneDataExample();
	    PhoneDataExample.Criteria criteria = example.createCriteria();
	    
	    if(id!=null) criteria.andIdEqualTo(id);
	    
	    if(phonedata!=null) criteria.andPhoneNumberEqualTo(phonedata);
	    
	    if(phonesafe!=null) criteria.andSafetyEqualTo(phonesafe);
	    PageHelper.startPage(pageNo, pageSize);
	    List<PhoneData> list = phonemapper.selectByExample(example);
	    
	    return list;
		
	}
	
	@Override
	public List<PhoneData> select_phone(Long id , Integer phonedata , Integer phonesafe){
	    PhoneDataExample example = new PhoneDataExample();
	    PhoneDataExample.Criteria criteria = example.createCriteria();
	    
	    if(id!=null) criteria.andIdEqualTo(id);
	    
	    if(phonedata!=null) criteria.andPhoneNumberEqualTo(phonedata);
	    
	    if(phonesafe!=null) criteria.andSafetyEqualTo(phonesafe);
	    
        List<PhoneData> list = phonemapper.selectByExample(example);
	    
	    return list;
		
	}
	
	@Override
	public int updatePhone(PhoneData phonedata){
		
		phonemapper.updateByPrimaryKeySelective(phonedata);
		return 1;
	}
	
	@Override
	public int addPhone(PhoneData phonedata){
		
		phonemapper.insertSelective(phonedata);
		return 1;
	}
	
	@Override
	public int deletePhone(PhoneData phonedata){
		
		phonemapper.deleteByPrimaryKey(phonedata.getId());
		return 1;
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
