package com.bankofshanghai.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.service.DataService;
import com.bankofshanghai.service.impl.DataServiceImpl;
import com.bankofshanghai.pojo.BankData;

public class CheckDrools {

	
	
	public static int check(BankData data, StatisticsData sData) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kc = ks.getKieClasspathContainer();
			KieSession kSession = kc.newKieSession("simpleRuleKSession");
 
			kSession.insert(data);
			kSession.insert(sData);
			int count = kSession.fireAllRules();
			System.out.println("总执行了" + count + "条规则");
			kSession.dispose();
            System.out.println(data.getSafeLevel());
			
			if (data.getSafeLevel()>=0){
				
				return data.getSafeLevel();
			}
		
			else{ 
				return -1; //检测失败
			}
		} catch (Throwable t) {
			t.printStackTrace();
			return -1;
		}
	}
}
