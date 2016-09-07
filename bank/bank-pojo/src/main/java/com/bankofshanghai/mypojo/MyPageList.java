package com.bankofshanghai.mypojo;

import java.util.List;

public class MyPageList<T> {
	
//	private Integer page;
//	
//	private Integer pageSize;
	
	/**
	 * 数据总量
	 */
	private Long total;
	
	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	
	
}
