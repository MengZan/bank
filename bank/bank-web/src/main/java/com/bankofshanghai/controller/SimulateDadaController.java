package com.bankofshanghai.controller;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SimulateDadaController {

	class Result {
		public String id;
		public String idFrom;
		public String idTo;
		public int money;
		public String city;
		public Date time;
		public int tag;

		Result() {
		};
	}

	@RequestMapping("/simulateNormal")
	@ResponseBody
	public void simulateNormalData(int moneyFrom, int moneyTo, String city, String timeFrom, String timeTo,
			int amount) {

		Result[] re = new Result[amount];
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < amount; i++) {
			re[i] = new Result();
			re[i].id = getFixLenthString(8);
			re[i].idFrom = "62" + getFixLenthString(16);
			re[i].idTo = "62" + getFixLenthString(16);
			re[i].money = randommoney(moneyTo, moneyFrom);
			re[i].city = city;
			re[i].time = randomDate(timeFrom, timeTo);
			re[i].tag = 0;
		}
		try {
			FileWriter fileWriter = new FileWriter("D:\\Result.csv", true);
			for (int k = 0; k < amount; k++) {
				fileWriter.write(re[k].id + ',' + re[k].idFrom + ',' + re[k].idTo + ',' + re[k].money + ',' + re[k].city
						+ ',' + format.format(re[k].time) + ',' + re[k].tag);
				fileWriter.write("\r\n");
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
	}

	@RequestMapping("/simulateFraud")
	@ResponseBody
	public void simulateFraudlData(int fraudNumIdFrom, int fraudNumIdTo1, int fraudNumIdTo2, int fraudMoneyFrom,
			int fraudMoneyTo, String fraudNumCity, String fraudTimeFrom, String fraudTimeTo, int timeRange,
			int timeType, double percent) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Result[] re_fraud = new Result[fraudNumIdFrom * fraudNumIdTo2];
		int j = 0;
		int temptag;
		String tempIdFrom;
		String tempId;
		Date tempdatebegin;
		Date tempdateend;

		for (int i = 0; i < fraudNumIdFrom; i++) {
			int temp = randomint(fraudNumIdTo2, fraudNumIdTo1);
			tempIdFrom = "62" + getFixLenthString(16);
			tempId = getFixLenthString(8);
			tempdatebegin = randomDateFraud(fraudTimeFrom, fraudTimeTo, timeType, timeRange);
			tempdateend = addOrMinusYear(tempdatebegin, timeType, -timeRange);
			temptag = (Math.random() < percent) ? 1 : 0;
			for (int k = 0; k < temp; k++) {
				re_fraud[j] = new Result();
				re_fraud[j].id = tempId;
				re_fraud[j].idFrom = tempIdFrom;
				re_fraud[j].idTo = "62" + getFixLenthString(16);
				re_fraud[j].money = randommoney(fraudMoneyTo, fraudMoneyFrom);
				re_fraud[j].city = fraudNumCity;
				re_fraud[j].time = randomDateFraudFinal(tempdatebegin, tempdateend);
				re_fraud[j].tag = temptag;
				j++;
			}

		}
		try {
			FileWriter fileWriter = new FileWriter("D:\\ResultFraud.csv", true);
			for (int k = 0; k < j; k++) {
				fileWriter.write(re_fraud[k].id + ',' + re_fraud[k].idFrom + ',' + re_fraud[k].idTo + ','
						+ re_fraud[k].money + ',' + re_fraud[k].city + ',' + format.format(re_fraud[k].time) + ','
						+ re_fraud[k].tag);
				fileWriter.write("\r\n");
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}

	}

	@RequestMapping("/simulateRule1")
	@ResponseBody
	public void simulateRule1Data(int numRule1, double rule1Percent) {
		Result[] re_rule1 = new Result[numRule1 * 10];
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int rule1k = 0;
		String rule1city = "中国上海上海";
		String tempRule1IdFrom;
		String tempRule1Id;
		Date tempRule1Date = new Date();
		Date tempRule1DateBegin;
		Date tempRule1DateEnd;
		int tempRule1tag;
		for (int i = 0; i < numRule1; i++) {
			int temp = randomint(3, 6);
			tempRule1IdFrom = "62" + getFixLenthString(16);
			tempRule1Id = getFixLenthString(8);
			tempRule1DateBegin = addOrMinusYear(tempRule1Date, 2, -6);
			tempRule1DateEnd = addOrMinusYear(tempRule1DateBegin, 5, 1);
			tempRule1tag = (Math.random() < rule1Percent) ? 1 : 0;
			for (int j = 0; j < temp; j++) {
				re_rule1[rule1k] = new Result();
				re_rule1[rule1k].id = tempRule1Id;
				re_rule1[rule1k].idFrom = tempRule1IdFrom;
				re_rule1[rule1k].idTo = "62" + getFixLenthString(16);
				re_rule1[rule1k].money = randommoney(300, 100);
				re_rule1[rule1k].city = rule1city;
				re_rule1[rule1k].time = randomDateFraudFinal(tempRule1DateBegin, tempRule1DateEnd);
				re_rule1[rule1k].tag = tempRule1tag;
				rule1k++;
			}
			re_rule1[rule1k] = new Result();
			re_rule1[rule1k].id = tempRule1Id;
			re_rule1[rule1k].idFrom = tempRule1IdFrom;
			re_rule1[rule1k].idTo = "62" + getFixLenthString(16);
			re_rule1[rule1k].money = randommoney(20000, 10000);
			re_rule1[rule1k].city = rule1city;
			re_rule1[rule1k].time = tempRule1DateEnd;
			re_rule1[rule1k].tag = tempRule1tag;
			rule1k++;
		}
		try {
			FileWriter fileWriter = new FileWriter("D:\\ResultFraud.csv", true);
			for (int k = 0; k < rule1k; k++) {
				fileWriter.write(re_rule1[k].id + ',' + re_rule1[k].idFrom + ',' + re_rule1[k].idTo + ','
						+ re_rule1[k].money + ',' + re_rule1[k].city + ',' + format.format(re_rule1[k].time) + ','
						+ re_rule1[k].tag);
				fileWriter.write("\r\n");
			}
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception er) {
			System.out.println(er.getMessage());
		}
	}

	private static int randomint(int max, int min) {
		Random random = new Random();
		int randomNumber = random.nextInt(max) % (max - min + 1) + min;
		return randomNumber;
	}

	private static int randommoney(int max, int min) {
		Random random = new Random();
		int temp = random.nextInt(max) % (max - min + 1) + min;
		int randomNumber = temp - temp % 100;
		return randomNumber;
	}

	private static String getFixLenthString(int strLength) {

		// Random rm = new Random();

		// 获得随机数
		// double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
		// double pross = (Math.random()*Math.pow(10, strLength));
		// 将获得的获得随机数转化为字符串
		String fixLenthString1 = String.valueOf(Math.random());
		String fixLenthString2 = String.valueOf(Math.random());
		// 返回固定的长度的随机数
		return (fixLenthString1.substring(2, strLength / 2 + 2) + fixLenthString2.substring(2, strLength / 2 + 2));
	}

	private static Date randomDate(String beginDate, String endDate) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date start = format.parse(beginDate);// 开始日期
			Date end = format.parse(endDate);// 结束日期
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());

			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Date randomDateFraudFinal(Date beginDate, Date endDate) {
		try {
			// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss");
			// Date start = format.parse(beginDate);// 开始日期
			Date start = beginDate;
			Date end = endDate;// 结束日期
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());

			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Date randomDateFraud(String beginDate, String endDate, int k, int i) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date start = format.parse(beginDate);// 开始日期
			Date temp = format.parse(endDate);// 结束日期
			Date end = addOrMinusYear(temp, k, i);
			if (start.getTime() >= end.getTime()) {
				return null;
			}
			long date = random(start.getTime(), end.getTime());

			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static long random(long begin, long end) {
		long rtnn = begin + (long) (Math.random() * (end - begin));
		if (rtnn == begin || rtnn == end) {
			return random(begin, end);
		}
		return rtnn;
	}

	public static Date addOrMinusYear(Date ti, int k, int i) {
		Date rtn = null;
		GregorianCalendar cal = new GregorianCalendar();
		// Date date = new Date(ti);
		cal.setTime(ti);
		cal.add(k, i);
		rtn = cal.getTime();
		return rtn;
		// 年份的加减，比如求一年后i=1，取1年前i=-1
		// 如果是月份加减cal.add(2, i);
		// 如果是星期加减cal.add(3, i);
		// 如果是每日加减cal.add(5, i);
		// 如果是小时加减cal.add(10, i);
		// 如果是分钟加减cal.add(12, i);
		// 如果是秒的加减cal.add(13, i);
	}

}
