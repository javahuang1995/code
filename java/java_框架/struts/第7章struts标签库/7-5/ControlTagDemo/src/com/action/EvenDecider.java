package com.action;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;
public class EvenDecider implements Decider{
	//ʵ��decide����
	public boolean decide(Object arg0) throws Exception {
		int i = ((Integer)arg0).intValue();		//ǿ��ת��Ϊint����
        	return (((i % 2) == 0)?true:false); 	//�ж���ż
	}
}
