package com.huang.adapter2;

public class ShouJiClient {
	TwoPinSocket tps;

	public TwoPinSocket getTps() {
		return tps;
	}

	public void setTps(TwoPinSocket tps) {
		this.tps = tps;
	}
	public void charge(){
		System.out.println("�ֻ���"+tps.voltage()+"�����³����");
	}
}
