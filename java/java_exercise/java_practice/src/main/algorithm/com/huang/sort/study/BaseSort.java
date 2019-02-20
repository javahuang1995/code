package com.huang.sort.study;

/**
 * 冒泡排序 选择排序 插入排序
 * 选择排序也就结束了，这样一弄有没有更清楚呢？ 那么好，是时候来总结下他们的区别了（划重点）。
 * （1）冒泡排序是比较相邻位置的两个数，而选择排序是按顺序比较，找最大值或者最小值；
 * （2）冒泡排序每一轮比较后，位置不对都需要换位置，选择排序每一轮比较都只需要换一次位置； （3）冒泡排序是通过数去找位置，选择排序是给定位置去找数；
 * 冒泡排序优缺点：优点:比较简单，空间复杂度较低，是稳定的； 缺点:时间复杂度太高，效率慢； 选择排序优缺点：优点：一轮比较只需要换一次位置；
 * 缺点：效率慢，不稳定（举个例子5，8，5，2，9 我们知道第一遍选择第一个元素5会和2交换，那么原序列中2个5的相对位置前后顺序就破坏了）。
 * 
 * @author Administrator
 *
 */
public class BaseSort {

	public static void main(String[] args) {
		int[] a = { 10, 3, 5, 2, 9, 6, 4, 3, 4, 5, 8 };

		// BaseSort.bubbleSort(a);
		// BaseSort.selectSort(a);
		BaseSort.insertSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}

	}

	/**
	 * 冒泡排序
	 * 
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i > 0; i--) // 外层比较N-1轮
		{
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1])
					swap(a, j, j + 1); // 交换，具体实现略
			}
		}
	}

	public void bubbleSort2(int[] a) {
		boolean exchange;
		for (int i = a.length - 1; i > 0; i--) {
			exchange = false;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					exchange = true;
				}
			}
			if (!exchange)
				return;
		}
	}

	/**
	 * 选择排序
	 * 
	 * @param a
	 */
	public static void selectSort(int[] a) {
		int min;
		for (int i = 0; i < a.length; i++) {
			min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min])
					min = j;
			}
			swap(a, i, min);// 交换放在循环体的外面。
		}
	}

	/**
	 * 插入排序
	 * 
	 * @param a
	 */
	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; (j > 0) && (a[j] < a[j - 1]); j--) {
				swap(a, j, j - 1);
			}
		}
	}

	public static void swap(int[] a, int j, int i) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
