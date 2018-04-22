package com.baobaotao.proxy;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import com.baobaotao.advice.GreetingBeforeAdvice;
import com.baobaotao.advice.NaiveWaiter;
import com.baobaotao.advice.Waiter;

public class TestBeforeAdvice {
	public static void main(String[] args) {
        Waiter target = new NaiveWaiter();//target类
        BeforeAdvice  advice = new GreetingBeforeAdvice();//advice
        ProxyFactory pf = new ProxyFactory();//代理工厂
        pf.setInterfaces(target.getClass().getInterfaces());//指定使用接口代理
        pf.setOptimize(true);//使用优化
        pf.setTarget(target);
        pf.addAdvice(advice);

        Waiter proxy = (Waiter)pf.getProxy(); //从代理工厂获取代理类
        proxy.greetTo("John");
        proxy.serveTo("Tom");
	}
}