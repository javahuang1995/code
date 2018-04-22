package com.huang.adapter2;

public class AmericaAdapter implements TwoPinSocket{

	ThreePinSocket threePinSocket;
	public AmericaAdapter(ThreePinSocket tps) {
		this.threePinSocket = tps;
	}
	public void chargeWithTwoPin() {
		threePinSocket.chargeWithThreePin();
		
	}

	public int voltage() {
		// TODO Auto-generated method stub
		return threePinSocket.voltage()*2;//��������110V��ѹ����220V
	}

}
