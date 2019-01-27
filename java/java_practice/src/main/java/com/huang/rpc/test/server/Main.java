package com.huang.rpc.test.server;

import com.huang.rpc.test.util.RpcFramework;

public class Main {
	public static void main(String[] args) {
		HelloService service = new HelloServiceImpl();
        // RPC��ܽ�����¶���������ͻ�������
        try {
			RpcFramework.export(service, 1234);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
