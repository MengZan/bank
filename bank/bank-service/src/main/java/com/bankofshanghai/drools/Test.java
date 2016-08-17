//package com.bankofshanghai.drools;
//
//import org.kie.api.KieServices;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//
//import com.bankofshanghai.pojo.BankData;
//public class Test {
//
//	
//	 public static final void main(String[] args) {
//	        try {
//	            // load up the knowledge base
//		        KieServices ks = KieServices.Factory.get();
//	    	    KieContainer kContainer = ks.getKieClasspathContainer();
//	        	KieSession kSession = kContainer.newKieSession("ksession-dtables");
//
//	            // go !
//	            BankData message = new BankData();
//	            message.setFromplace("地点1");
//	            kSession.insert(message);
//	            kSession.fireAllRules();
//	        } catch (Throwable t) {
//	            t.printStackTrace();
//	        }
//	    }
//	
//}