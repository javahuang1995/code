package com.huang.reflect;
/**
 * 写一个程序根据用户提供的类名，调用该类的里的main方法。
 */
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, Exception {
        String str = args[0];
        /*
         * 这样会数组角标越界，因为压根没有这个字符数组
         * 需要右键在run as-configurations-arguments里输入b.Inter（完整类名）
         * 
         */
        Method m = Class.forName(str).getMethod("main",String[].class);
        //下面这两种方式都可以,main方法需要一个参数
        //invoke的第一个参数是对哪个对象调用这个方法，如果是静态方法，那么就没有对象，第一个参数就是null,其他参数是方法的参数
        m.invoke(null, new Object[]{new String[]{"111","222","333"}});
        m.invoke(null, (Object)new String[]{"111","222","333"});//这个可以说明，数组也是Object
        /*
         * m.invoke(null, new String[]{"111","222","333"})
         * 上面的不可以,因为java会自动拆包
         */
    }
}

class Inter {
    public static void main(String[] args) {
        for(Object obj : args) {
            System.out.println(obj);
        }
    }
}