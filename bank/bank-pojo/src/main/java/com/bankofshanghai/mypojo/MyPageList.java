package com.bankofshanghai.mypojo;

import java.util.List;

public class MyPageList<T> {
	
	private Integer pageNos;
	
	private Integer pageCount;
	
	private List<T> list;

	public Integer getPageNos() {
		return pageNos;
	}

	public void setPageNos(Integer pageNos) {
		this.pageNos = pageNos;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
