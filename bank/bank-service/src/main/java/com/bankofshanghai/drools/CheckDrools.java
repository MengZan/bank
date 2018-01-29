package com.bankofshanghai.drools;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.service.StatisticsService;
import com.bankofshanghai.service.impl.StatisticsServiceImpl;

public class CheckDrools {

	private static Logger log = Logger.getLogger(CheckDrools.class.getName());
	private static KieContainer kc;
	private KieSession kSession = null;

	static {
		kc = KnowledgeSessionHelper.createRuleBase();
	}

	public Boolean preCheck(BankData data, StatisticsData sData) {
//		if (data.getTouserCredit() < 0 || !sData.getCommonFromPlace().equals(data.getFromplace())
//				|| sData.getIsNewUser() == true || sData.getMoneyWithinTime() >= 11000)
//			return true;
		return false;
	}

	public int check(BankData data, StatisticsData sData) {
		try {
			kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "bankRule2");
			kSession.insert(data);
			kSession.insert(sData);
			// 全加载
			kSession.fireAllRules();
			int safeLevel = data.getSafeLevel();
			if (safeLevel > 60)
				log.info(data.getId() + "---------------检测到疑似欺诈交易！！！------------------");
			return safeLevel;
		} catch (Exception e) {
			log.warn(data.getId() + "---------------Drools检测失败------------------", e);
			data.setSafeLevel(-1);
			return -1;
		} finally {
			if (kSession != null)
				kSession.dispose();
		}
	}
	
	public static void main(String[] args) {
		BankData data = new BankData();
		StatisticsService ss = new StatisticsServiceImpl();
		data.setId((long) 11);
		data.setFromuser((long) 11);
		data.setTouser((long) 111);
		data.setMoney(new BigDecimal("11.11"));
		data.setFromplace("上海");
		data.setToplace("上海");
		data.setDatetime(new Date());
		data.setTouserCredit(0);
		data.setTool("手机");
		data.setFromuserOpendate(new Date());
		data.setSafeLevel(0);
		data.setIsFraud(false);
		StatisticsData sData = ss.getStatisticDataLocal(data);
		CheckDrools drools = new CheckDrools();
//		if (drools.preCheck(data, sData)) {
//			drools.check(data, sData);
//		}
		drools.check(data, sData);
		System.out.println(data.getSafeLevel());
	}
}
