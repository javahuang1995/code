package com.huang.collection;

import java.util.HashSet;
import java.util.Hashtable;

public class MainApp {
	
	public static void main(String[] args) {
		Hashtable a = new Hashtable<String,String>();
		
		HashSet b = new HashSet<String>();//���԰�hashset���Ϊ��ͳ�Ĺ�ϣ����ΪvalueΪnull.��ʹ�г�ͻҲ������
		b.add("aa");
		b.add("aa");
		
		//�е�ʱ����Ҫ������һ����������ȡ���ݣ�ͬ��Ҫ������ظ����ݡ�
		//1.��������ӵ�HashSet����
		//2.ʹ���������Ͽ�ܣ�����HashMap,HashTable,ArrayList,����ӵ�ʱ�����һ���ж�
		//if(!list.contains(this)) list.add(this)
		
		System.out.println(b);
		
	}

}
