package com.action;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;
public class EvenDecider implements Decider{
	//实现decide方法
	public boolean decide(Object arg0) throws Exception {
		int i = ((Integer)arg0).intValue();		//强制转换为int类型
        	return (((i % 2) == 0)?true:false); 	//判断奇偶
	}
}
