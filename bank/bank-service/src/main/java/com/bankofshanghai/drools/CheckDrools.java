package com.bankofshanghai.drools;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;

import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;

public class CheckDrools {

	private static Logger log = Logger.getLogger(CheckDrools.class.getName());

	private static KieContainer kc;
	private KieSession kSession = null;

	static {
		kc = KnowledgeSessionHelper.createRuleBase();
	}

	public int check(BankData data, StatisticsData sData) {
		try {
			kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kc, "bankRule");
			final Set<String> clusters = new HashSet<>();
			if (data.getTouserCredit() < 0)
				clusters.add("Cluster1");
			if (!data.getFromplace().equals(sData.getCommonFromPlace()))
				clusters.add("Cluster2");
			if (sData.getIsNewUser() == true)
				clusters.add("Cluster3");
			if (sData.getMoneyWithinTime() >= 5000.00)
				clusters.add("Cluster4");
			if (clusters.size() == 0)
				return 0;
			kSession.insert(data);
			kSession.insert(sData);
			// 选择性加载
			kSession.fireAllRules(new AgendaFilter() {
				@Override
				public boolean accept(Match match) {
					String name = match.getRule().getName();
					for (String cluster : clusters) {
						if (name.contains(cluster))
							return true;
					}
					return false;
				}
			});
			int safeLevel = data.getSafeLevel();
			if (safeLevel > 60)
				log.info(data.getId() + "---------------检测到疑似欺诈交易！------------------");
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

	public int check2(BankData data, StatisticsData sData) {
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
}
