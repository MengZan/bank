package com.bankofshanghai.drools;

import java.text.SimpleDateFormat;
import java.util.Date;
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

	
	 public static final void main(String[] args) {
       try {
    	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    	   
    	 Date t=simpleDateFormat.parse("20120822");
    	 System.out.println(t);
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	    }
	
}