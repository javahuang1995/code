package com.huang.annotation.test;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validate.java
 * 自定义注解
 * @author IT唐伯虎 2014年7月11日
 */
@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate
{
    public int min() default 1;

    public int max() default 10;

    public boolean isNotNull() default true;
}