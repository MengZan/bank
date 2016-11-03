package com.bankofshanghai.mypojo;

/**
 * 地区分布
 * 
 * @author DMM
 *
 */
public class AreaDistribute {

	private double Guangdong;
	private double Fujian;
	private double Shanghai;
	private double Beijing;
	private double Guizhou;
	private double Others;

	public AreaDistribute(double guangdong, double fujian, double shanghai, double beijing, double guizhou,
			double others) {
		this.Guangdong = guangdong;
		this.Fujian = fujian;
		this.Shanghai = shanghai;
		this.Beijing = beijing;
		this.Guizhou = guizhou;
		this.Others = others;
	}

	public double getGuangdong() {
		return Guangdong;
	}

	public void setGuangdong(double guangdong) {
		Guangdong = guangdong;
	}

	public double getFujian() {
		return Fujian;
	}

	public void setFujian(double fujian) {
		Fujian = fujian;
	}

	public double getShanghai() {
		return Shanghai;
	}

	public void setShanghai(double shanghai) {
		Shanghai = shanghai;
	}

	public double getBeijing() {
		return Beijing;
	}

	public void setBeijing(double beijing) {
		Beijing = beijing;
	}

	public double getGuizhou() {
		return Guizhou;
	}

	public void setGuizhou(double guizhou) {
		Guizhou = guizhou;
	}

	public double getOthers() {
		return Others;
	}

	public void setOthers(double others) {
		Others = others;
	}

}
