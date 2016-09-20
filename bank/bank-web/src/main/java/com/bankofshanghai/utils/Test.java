package com.bankofshanghai.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;

import com.bankofshanghai.mypojo.BankResult;
import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.service.UsermanService;
import com.bankofshanghai.service.impl.UsermanServiceImpl;
import com.bankofshanghai.utils.JsonUtils;

//
//import org.kie.api.KieServices;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//
//import com.bankofshanghai.pojo.BankData;
public class Test {

	static UsermanServiceImpl usermanService = new UsermanServiceImpl();
	
	 public static final void main(String[] args) {
       try {
    	   

    	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    	    // CST(北京时间)在东8区  
    	    sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));  
    	    System.out.println(sdf.parse(sdf.format(new Date()))); 
    	    
    	    
    	   
    	   
    	   
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	    }
	
}