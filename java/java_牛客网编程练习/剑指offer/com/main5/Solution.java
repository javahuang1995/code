package com.main5;

import java.util.ArrayList;

/**
 * ��Ŀ���� ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�� ���������СֵΪ1�� NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 * 
 * @author Administrator ���� 2018-4-21����07:10:41
 */
public class Solution {
	public int minNumberInRotateArray(int[] array) {

		if (array.length == 0) {//�����СΪ0������0
			return 0;
		}
		if (array.length == 1) {//���ֻ��һ��Ԫ��
			return array[0];
		}

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i + 1] < array[i]  ) 
			{
				return array[i + 1];//����3,4,5,2,1, ��5����2��˵��2������С��Ԫ��
			} else 
			{
				if (i == array.length - 2)
					//�����5,1,2,3,4,����4,5,1,2,3,4,�����ٽ�����ڵ�һ��if�Ϳ����жϳ���
					//����1,2,3,4,5 �����������i==array.length-2��ʱ��Ϳ����жϣ��Ǹ�ȫ�����ǵ��������飬����Ҫ
					//�жϵ�i==array.length
				{
					return array[0];
				}
			}
		}//end for

		return 0;
	}
}