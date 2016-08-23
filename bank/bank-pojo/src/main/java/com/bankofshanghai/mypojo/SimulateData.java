package com.bankofshanghai.mypojo;

public class SimulateData {

		// ---------------------------------------------正常
		int moneyFrom;
		int moneyTo;
		String city;
		String timeFrom;
		String timeTo;
		int amount;
		// ------------------------------------------------------------------欺诈参数
		int fraudNumIdFrom;
		int fraudNumIdTo1;
		int fraudNumIdTo2;
		int fraudMoneyFrom;
		int fraudMoneyTo;
		int fraudNumCity;
		String fraudTimeFrom;
		String fraudTimeTo;
		int timeRange;
		int timeType;
		double percent;
		// 年份的加减，比如求一年后i=1，取1年前i=-1
		// 如果是月份加减cal.add(2, i);
		// 如果是星期加减cal.add(3, i);
		// 如果是每日加减cal.add(5, i);
		// 如果是小时加减cal.add(10, i);
		// 如果是分钟加减cal.add(12, i);
		// 如果是秒的加减cal.add(13, i);
		// ----------------------------------------------------------------------rule1参数
		int ruleType1;
		int numRule1;
		double rule1Percent;
		public int getMoneyFrom() {
			return moneyFrom;
		}
		public void setMoneyFrom(int moneyFrom) {
			this.moneyFrom = moneyFrom;
		}
		public int getMoneyTo() {
			return moneyTo;
		}
		public void setMoneyTo(int moneyTo) {
			this.moneyTo = moneyTo;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getTimeFrom() {
			return timeFrom;
		}
		public void setTimeFrom(String timeFrom) {
			this.timeFrom = timeFrom;
		}
		public String getTimeTo() {
			return timeTo;
		}
		public void setTimeTo(String timeTo) {
			this.timeTo = timeTo;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public int getFraudNumIdFrom() {
			return fraudNumIdFrom;
		}
		public void setFraudNumIdFrom(int fraudNumIdFrom) {
			this.fraudNumIdFrom = fraudNumIdFrom;
		}
		public int getFraudNumIdTo1() {
			return fraudNumIdTo1;
		}
		public void setFraudNumIdTo1(int fraudNumIdTo1) {
			this.fraudNumIdTo1 = fraudNumIdTo1;
		}
		public int getFraudNumIdTo2() {
			return fraudNumIdTo2;
		}
		public void setFraudNumIdTo2(int fraudNumIdTo2) {
			this.fraudNumIdTo2 = fraudNumIdTo2;
		}
		public int getFraudMoneyFrom() {
			return fraudMoneyFrom;
		}
		public void setFraudMoneyFrom(int fraudMoneyFrom) {
			this.fraudMoneyFrom = fraudMoneyFrom;
		}
		public int getFraudMoneyTo() {
			return fraudMoneyTo;
		}
		public void setFraudMoneyTo(int fraudMoneyTo) {
			this.fraudMoneyTo = fraudMoneyTo;
		}
		public int getFraudNumCity() {
			return fraudNumCity;
		}
		public void setFraudNumCity(int fraudNumCity) {
			this.fraudNumCity = fraudNumCity;
		}
		public String getFraudTimeFrom() {
			return fraudTimeFrom;
		}
		public void setFraudTimeFrom(String fraudTimeFrom) {
			this.fraudTimeFrom = fraudTimeFrom;
		}
		public String getFraudTimeTo() {
			return fraudTimeTo;
		}
		public void setFraudTimeTo(String fraudTimeTo) {
			this.fraudTimeTo = fraudTimeTo;
		}
		public int getTimeRange() {
			return timeRange;
		}
		public void setTimeRange(int timeRange) {
			this.timeRange = timeRange;
		}
		public int getTimeType() {
			return timeType;
		}
		public void setTimeType(int timeType) {
			this.timeType = timeType;
		}
		public double getPercent() {
			return percent;
		}
		public void setPercent(double percent) {
			this.percent = percent;
		}
		public int getRuleType1() {
			return ruleType1;
		}
		public void setRuleType1(int ruleType1) {
			this.ruleType1 = ruleType1;
		}
		public int getNumRule1() {
			return numRule1;
		}
		public void setNumRule1(int numRule1) {
			this.numRule1 = numRule1;
		}
		public double getRule1Percent() {
			return rule1Percent;
		}
		public void setRule1Percent(double rule1Percent) {
			this.rule1Percent = rule1Percent;
		}
}
