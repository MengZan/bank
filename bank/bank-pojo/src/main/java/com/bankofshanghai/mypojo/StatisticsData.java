package com.bankofshanghai.mypojo;

/**
 * 统计量
 * 
 * @author DMM
 *
 */
public class StatisticsData {
	private double moneyWithinTime;

	private String commonFromPlace;

	private double moneyOfDay;

	private int timesOfDay;
	
	private int avgTimes;

	public double getMoneyWithinTime() {
		return moneyWithinTime;
	}

	public void setMoneyWithinTime(double moneyWithinTime) {
		this.moneyWithinTime = moneyWithinTime;
	}

	public String getCommonFromPlace() {
		return commonFromPlace;
	}

	public void setCommonFromPlace(String commonFromPlace) {
		this.commonFromPlace = commonFromPlace;
	}

	public double getMoneyOfDay() {
		return moneyOfDay;
	}

	public void setMoneyOfDay(double moneyOfDay) {
		this.moneyOfDay = moneyOfDay;
	}

	public int getTimesOfDay() {
		return timesOfDay;
	}

	public void setTimesOfDay(int timesOfDay) {
		this.timesOfDay = timesOfDay;
	}

	public int getAvgTimes() {
		return avgTimes;
	}

	public void setAvgTimes(int avgTimes) {
		this.avgTimes = avgTimes;
	}
	
}