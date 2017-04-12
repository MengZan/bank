package com.bankofshanghai.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bankofshanghai.mypojo.StatisticsData;
import com.bankofshanghai.pojo.BankData;
import com.bankofshanghai.service.StatisticsService;
import com.bankofshanghai.spark.MyJedisPool;

import redis.clients.jedis.Jedis;

@Service
public class StatisticsServiceImpl implements StatisticsService, Serializable {

	private static Logger log = Logger.getLogger(StatisticsServiceImpl.class.getName());

	@Override
	public StatisticsData getStatisticData(BankData data) {
		StatisticsData sData = new StatisticsData();
		Jedis jedis = null;
		try {
			// 从jedis池中获取一个jedis实例
			jedis = MyJedisPool.pool.getResource();
			sData.setMoneyWithinTime(moneyWithinTime(jedis, data));
			sData.setMoneyOfDay(moneyOfDay(jedis, data));
			sData.setCommonFromPlace(commonFromPlace(jedis, data));
			sData.setIsNewUser(isNewUser(jedis, data));
			return sData;
		} catch (Exception e) {
			log.warn(data.getId() + "----------------Redis连接失败----------------", e);
			sData.setMoneyWithinTime(0);
			sData.setMoneyOfDay(0);
			sData.setCommonFromPlace("上海");
			sData.setIsNewUser(false);
			return sData;
		} finally {
			if(jedis!=null)
				jedis.close();
		}
	}

	private static double moneyWithinTime(Jedis jedis, BankData data) {
		// String key = data.getFromuser() + "MWT";
		// double money = 0;
		// if (!jedis.exists(key)) {
		// money = data.getMoney().doubleValue();
		// jedis.setex(key, 60 * 30, String.valueOf(money));
		// return 0;
		// } else {
		// money = data.getMoney().doubleValue() +
		// Double.parseDouble(jedis.get(key));
		// jedis.setex(key, 60 * 30, String.valueOf(money));
		// return money;
		// }

		return data.getMoney().doubleValue();
	}

	private static double moneyOfDay(Jedis jedis, BankData data) {
		String key = data.getFromuser() + "MOD";
		String field = String.valueOf(data.getDatetime().getDate());
		double money = 0;
		String s = jedis.hget(key, field);
		if (s == null) {
			// jedis.del(key);
			money = data.getMoney().doubleValue();
			jedis.hset(key, field, String.valueOf(money));
		} else {
			money = Double.parseDouble(s) + data.getMoney().doubleValue();
			jedis.hset(key, field, String.valueOf(money));
		}
		return money;
	}

	private static String commonFromPlace(Jedis jedis, BankData data) {
		return "上海";
	}

	private static boolean isNewUser(Jedis jedis, BankData data) {
		String key = data.getFromuser() + "INU";
		if (jedis.exists(key) && jedis.get(key) == "false")
			return false;
		int diff = (int) (data.getDatetime().getTime() - data.getFromuserOpendate().getTime()) / (1000 * 60 * 60 * 24);
		if (diff < 7) {
			jedis.setex(key, 60 * 60 * 24, "true");
			return true;
		} else {
			jedis.set(key, "false");
			return false;
		}
	}

}
