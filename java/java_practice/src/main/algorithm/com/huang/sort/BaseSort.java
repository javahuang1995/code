package com.huang.sort;

public class BaseSort {

	public static void main(String[] args) {
		int[] test = {10,3,5,2,9,6,4,3,4,5,8};
		
		BaseSort.bubbleSort(test);
		for(int i=0;i<test.length;i++){
			System.out.println(test[i]);
		}
		
	}
	public static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i > 0; i--) {
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

	public void selectSort(int[] a) {
		int min;
		for (int i = 0; i < a.length; i++) {
			min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min])
					min = j;
			}
			swap(a,i, min);
		}
	}

	public void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; (j > 0) && (a[j] < a[j - 1]); j--) {
				swap(a,j, j - 1);
			}
		}
	}
	

	public static void swap(int[] a, int j, int i) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	

}
