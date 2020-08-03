package com.twu.refactoring;

public class Movie {
	public static final int  CHILDRENS = 2;
	public static final int  REGULAR = 0;
	public static final int  NEW_RELEASE = 1;
	public static final double  REGULAR_AMOUNT = 2;
	public static final int  REGULAR_LIMIT_DAY = 2;
	public static final double  REGULAR_RATIO = 1.5;
	public static final double  RELEASE_RATIO = 3;
	public static final double  CHILDRENS_AMOUNT = 1.5;
	public static final int  CHILDRENS_LIMIT_DAY = 3;
	public static final double CHILDRENS_RATIO = 1.5;
	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
    	priceCode = arg;
	}

	public String getTitle () {
		return title;
	}
}

