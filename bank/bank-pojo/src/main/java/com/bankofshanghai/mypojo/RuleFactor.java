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
