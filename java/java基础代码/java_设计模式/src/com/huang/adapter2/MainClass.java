package com.huang.adapter2;

public class MainClass {
	public static void main(String[] args) {
		TwoPinSocketChina tpc = new TwoPinSocketChina();
		ShouJiClient phone = new ShouJiClient();
		phone.setTps(tpc);
		phone.charge();
		
	}
}
