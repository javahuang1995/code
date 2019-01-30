package com.huang.rpc.test.client;

import com.huang.rpc.test.util.RpcFramework;

public class RpcConsumer {
	public static void main(String[] args) throws Exception {
		// ��RpcFramework���ɵ�HelloService�Ĵ���
		HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
		String hello = service.hello("World");
		System.out.println("�ͻ����յ�Զ�̵��õĽ�� �� " + hello);
	}
}
