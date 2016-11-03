package com.bankofshanghai.mypojo;

import java.util.List;

/**
 * 欺诈交易统计
 * 
 * @author DMM
 *
 */
public class FraudStatistic {

	private List<MyDataList> data;
	private BusinessDistribute businessDistribute;
	private MoneyDistribute moneyDistribute;
	private AreaDistribute areaDistribute;
	private Long total;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<MyDataList> getData() {
		return data;
	}

	public void setData(List<MyDataList> data) {
		this.data = data;
	}

	public BusinessDistribute getBusinessDistribute() {
		return businessDistribute;
	}

	public void setBusinessDistribute(BusinessDistribute businessDistribute) {
		this.businessDistribute = businessDistribute;
	}

	public MoneyDistribute getMoneyDistribute() {
		return moneyDistribute;
	}

	public void setMoneyDistribute(MoneyDistribute moneyDistribute) {
		this.moneyDistribute = moneyDistribute;
	}

	public AreaDistribute getAreaDistribute() {
		return areaDistribute;
	}

	public void setAreaDistribute(AreaDistribute areaDistribute) {
		this.areaDistribute = areaDistribute;
	}

}
