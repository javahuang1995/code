package com.baobaotao.proxy;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import com.baobaotao.advice.GreetingBeforeAdvice;
import com.baobaotao.advice.NaiveWaiter;
import com.baobaotao.advice.Waiter;

public class TestBeforeAdvice {
	public static void main(String[] args) {
        Waiter target = new NaiveWaiter();//target��
        BeforeAdvice  advice = new GreetingBeforeAdvice();//advice
        ProxyFactory pf = new ProxyFactory();//������
        pf.setInterfaces(target.getClass().getInterfaces());//ָ��ʹ�ýӿڴ���
        pf.setOptimize(true);//ʹ���Ż�
        pf.setTarget(target);
        pf.addAdvice(advice);

        Waiter proxy = (Waiter)pf.getProxy(); //�Ӵ�������ȡ������
        proxy.greetTo("John");
        proxy.serveTo("Tom");
	}
}