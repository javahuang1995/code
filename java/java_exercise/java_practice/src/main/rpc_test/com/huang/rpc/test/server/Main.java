package com.huang.rpc.test.server;

import com.huang.rpc.test.util.RpcFramework;

public class Main {
	public static void main(String[] args) {
		HelloService service = new HelloServiceImpl();
        // RPC框架将服务暴露出来，供客户端消费
        try {
			RpcFramework.export(service, 1234);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
