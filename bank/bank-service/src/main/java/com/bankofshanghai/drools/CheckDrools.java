package com.bankofshanghai.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.pojo.DataTri;

public class CheckDrools {

	
	
	public static int[] check(BankData data, StatisticsData sData,DataTri datatri) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kc = ks.getKieClasspathContainer();
			KieSession kSession = kc.newKieSession("simpleRuleKSession");
 
			kSession.insert(data);
			kSession.insert(sData);
			kSession.insert(datatri);
			int count = kSession.fireAllRules();
			System.out.println("总执行了" + count + "条规则");
			kSession.dispose();
            System.out.println(data.getSafeLevel());
            
            int[] temp = new int[12];
            temp[0] = datatri.getTri1();
            temp[1] = datatri.getTri2();
            temp[2] = datatri.getTri3();
            temp[3] = datatri.getTri4();
            temp[4] = datatri.getTri5();
            temp[5] = datatri.getTri6();
            temp[6] = datatri.getTri7();
            temp[7] = datatri.getTri8();
            temp[8] = datatri.getTri9();
            temp[9] = datatri.getTri10();
            temp[10] = datatri.getTri11();
            temp[11] = datatri.getTri12();
            
            
			int[] result = new int[13];
			for(int i=1; i<13;i++){
				result[i] = temp[i-1];
			}
			if (data.getSafeLevel()>=0){
				
				result[0]=data.getSafeLevel();
				//return data.getSafeLevel();
			}
		
			else{ 
				result[0]=-1; //检测失败
			}
			return result;
		} catch (Throwable t) {
			t.printStackTrace();
			int[] result = new int[13];
			result[0]=-1;
			return result;
		}
		
	}
}
