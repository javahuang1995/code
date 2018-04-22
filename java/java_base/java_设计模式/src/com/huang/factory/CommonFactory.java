package com.huang.factory;
/**
 * 这个工厂类使用了反射机制，泛型技术，单例模式
 * @author Administrator
 *
 */
public class CommonFactory {
    public static <T> T getClass(Class<? extends T> clazz) {
        T obj = null;

        try {
            obj = (T) Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }
}