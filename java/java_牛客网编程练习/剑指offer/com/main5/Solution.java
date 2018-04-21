package com.main5;

import java.util.ArrayList;

/**
 * 题目描述 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转， 该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * @author Administrator 黄宁 2018-4-21下午07:10:41
 */
public class Solution {
	public int minNumberInRotateArray(int[] array) {

		if (array.length == 0) {//数组大小为0，返回0
			return 0;
		}
		if (array.length == 1) {//如果只有一个元素
			return array[0];
		}

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i + 1] < array[i]  ) 
			{
				return array[i + 1];//比如3,4,5,2,1, 当5大于2，说明2就是最小的元素
			} else 
			{
				if (i == array.length - 2)
					//如果是5,1,2,3,4,或者4,5,1,2,3,4,这种临界情况在第一个if就可以判断出来
					//所以1,2,3,4,5 这种情况，当i==array.length-2的时候就可以判断，是个全部都是递增的数组，不需要
					//判断到i==array.length
				{
					return array[0];
				}
			}
		}//end for

		return 0;
	}
}