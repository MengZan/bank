package com.bankofshanghai.mypojo;

/**
 * 业务分布
 *
 */
public class Business {
	/**
	 * 网上银行
	 */
	private double wsyh;
	/**
	 * 手机银行
	 */
	private double sjyh;
	/**
	 * 电话银行
	 */
	private double dhyh;
	/**
	 * 微信银行
	 */
	private double wxyh;
	
	public Business(double wsyh, double sjyh, double dhyh, double wxyh){
		this.wsyh = wsyh;
		this.sjyh = sjyh;
		this.dhyh = dhyh;
		this.wxyh = wxyh;
	}

	public double getWsyh() {
		return wsyh;
	}

	public double getSjyh() {
		return sjyh;
	}

	public double getDhyh() {
		return dhyh;
	}

	public double getWxyh() {
		return wxyh;
	}
	
}
