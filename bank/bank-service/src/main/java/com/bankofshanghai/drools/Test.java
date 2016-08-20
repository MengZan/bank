package com.bankofshanghai.drools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bankofshanghai.pojo.BankUser;
import com.bankofshanghai.service.UsermanService;

//
//import org.kie.api.KieServices;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//
//import com.bankofshanghai.pojo.BankData;
public class Test {

	@Autowired
	private static  UsermanService usermanService;
	
	 public static final void main(String[] args) {
       try {
    	   
    	   
    	   int pageNo=1;
    	   int rows=10;
    	   Long userid=(long) 1;
    	   int usertype_t=2;
    	   
    	   List<BankUser> list=usermanService.queryByPage(pageNo, rows, userid, usertype_t);
    	   if(list!=null)
    	   System.out.println("1");
    	   else System.out.println("2");
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	    }
	
}