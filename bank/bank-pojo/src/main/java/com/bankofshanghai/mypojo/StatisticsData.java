package com.bankofshanghai.mypojo;

import java.util.List;

import com.bankofshanghai.pojo.BankData;

/**
 * 统计量
 * @author DMM
 *
 */
public class StatisticsData {
	private int dataNumbers;
	
	private int dataNumbersFromTime;
	
	private String commonFromPlace;

	public String getCommonFromPlace() {
		return commonFromPlace;
	}

	public void setCommonFromPlace(String commonFromPlace) {
		this.commonFromPlace = commonFromPlace;
	}

	public int getDataNumbers() {
		return dataNumbers;
	}

	public void setDataNumbers(int dataNumbers) {
		this.dataNumbers = dataNumbers;
	}

	public int getDataNumbersFromTime() {
		return dataNumbersFromTime;
	}

	public void setDataNumbersFromTime(int dataNumbersFromTime) {
		this.dataNumbersFromTime = dataNumbersFromTime;
	}

}
