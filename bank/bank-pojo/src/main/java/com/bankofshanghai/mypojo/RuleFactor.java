package com.bankofshanghai.mypojo;

/**
 * 规则参数
 * @author DMM
 *
 */
public class RuleFactor {
	private String time;
	
	private Integer deals;
	
	private Boolean isCommonFromPlace;
	
	private Double moneyOfDay;
	
	private Integer toUsersOfDay;

	public Integer getToUsersOfDay() {
		return toUsersOfDay;
	}

	public void setToUsersOfDay(Integer toUsersOfDay) {
		this.toUsersOfDay = toUsersOfDay;
	}

	public Double getMoneyOfDay() {
		return moneyOfDay;
	}

	public void setMoneyOfDay(Double moneyOfDay) {
		this.moneyOfDay = moneyOfDay;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Boolean getIsCommonFromPlace() {
		return isCommonFromPlace;
	}

	public void setIsCommonFromPlace(Boolean isCommonFromPlace) {
		this.isCommonFromPlace = isCommonFromPlace;
	}
}
