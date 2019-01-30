package com.huang.reflect;
import java.lang.reflect.*;
/**
 * �������������ʱ��֪��Ҫ����������ʲô�����ҿ���������ʱ��ȡ����������죬�����ö�Ӧ�ķ�����
 * @author huang
 *
 */
public class Apple {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @SuppressWarnings(value = { "unchecked" })
    public static void main(String[] args) throws Exception{
        //�����ĵ���
        Apple apple = new Apple();
        apple.setPrice(5);
        System.out.println("Apple Price:" + apple.getPrice());
        
        //ʹ�÷������
        Class clz = Class.forName("com.huang.reflect.Apple");
        Constructor appleConstructor = clz.getConstructor();
        Method setPriceMethod = clz.getMethod("setPrice", int.class);//��һ�������Ƿ��������ڶ��������Ƿ����Ĳ������͡�
        Object appleObj = appleConstructor.newInstance();
        setPriceMethod.invoke(appleObj, 14);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
        
        
        Method[] methodList = clz.getMethods();
        for (Method method : methodList) {
            System.out.println("method is "+method.getName()+"()");
        }
        
        //��ȡ����
        Field[] fields = clz.getFields();
        for (Field field : fields) {
            System.out.println("filed is "+field.getName());
        }
        
        
    }
}