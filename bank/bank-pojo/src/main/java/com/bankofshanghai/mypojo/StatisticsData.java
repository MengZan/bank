package com.bankofshanghai.mypojo;

import java.math.BigDecimal;

/**
 * 统计量
 * @author DMM
 *
 */
public class StatisticsData {
	private Integer dataNumbers;
	
	private Integer dataNumbersWithinTime;
	
	private String commonFromPlace;
	
	private Double moneyOfDay;
	
	private Integer toUsersOfDay;

	public Integer getToUsersOfDay() {
		return toUsersOfDay;
	}

	public void setToUsersOfDay(Integer toUsersOfDay) {
		this.toUsersOfDay = toUsersOfDay;
	}

	public Integer getDataNumbers() {
		return dataNumbers;
	}

	public void setDataNumbers(Integer dataNumbers) {
		this.dataNumbers = dataNumbers;
	}

	public Integer getDataNumbersWithinTime() {
		return dataNumbersWithinTime;
	}

	public void setDataNumbersWithinTime(Integer dataNumbersWithinTime) {
		this.dataNumbersWithinTime = dataNumbersWithinTime;
	}

	public String getCommonFromPlace() {
		return commonFromPlace;
	}

	public void setCommonFromPlace(String commonFromPlace) {
		this.commonFromPlace = commonFromPlace;
	}

	public Double getMoneyOfDay() {
		return moneyOfDay;
	}

	public void setMoneyOfDay(Double moneyOfDay) {
		this.moneyOfDay = moneyOfDay;
	}
	
}