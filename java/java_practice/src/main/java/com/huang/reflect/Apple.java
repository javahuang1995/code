package com.huang.reflect;
import java.lang.reflect.*;
/**
 * 反射就是在运行时才知道要操作的类是什么，并且可以在运行时获取类的完整构造，并调用对应的方法。
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
        //正常的调用
        Apple apple = new Apple();
        apple.setPrice(5);
        System.out.println("Apple Price:" + apple.getPrice());
        
        //使用反射调用
        Class clz = Class.forName("com.huang.reflect.Apple");
        Constructor appleConstructor = clz.getConstructor();
        Method setPriceMethod = clz.getMethod("setPrice", int.class);//第一个参数是方法名，第二个参数是方法的参数类型。
        Object appleObj = appleConstructor.newInstance();
        setPriceMethod.invoke(appleObj, 14);
        Method getPriceMethod = clz.getMethod("getPrice");
        System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
        
        
        Method[] methodList = clz.getMethods();
        for (Method method : methodList) {
            System.out.println("method is "+method.getName()+"()");
        }
        
        //获取属性
        Field[] fields = clz.getFields();
        for (Field field : fields) {
            System.out.println("filed is "+field.getName());
        }
        
        
    }
}