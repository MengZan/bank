package com.bankofshanghai.utils;

import java.util.List;

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
    	   
    	   Long userid = (long) 1;
    	   BankUser user = usermanService.getUserByID(userid);
    	   BankResult bankresult = BankResult.ok(user);
    	   System.out.println(bankresult);
    	   
    	   
    	   
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	    }
	
}