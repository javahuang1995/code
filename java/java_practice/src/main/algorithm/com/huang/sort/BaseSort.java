package com.huang.sort;

public class BaseSort {

	public void bubbleSort(int[] source) {
		for (int i = source.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1])
					swap(source, j, j + 1); // 交换，具体实现略
			}
		}
	}

	public void bubbleSort(int[] source) {
		boolean exchange;
		for (int i = source.length - 1; i > 0; i--) {
			exchange = false;
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					swap(source, j, j + 1);
					exchange = true;
				}
			}
			if (!exchange)
				return;
		}
	}

	public void selectSort(int[] source) {
		int min;
		for (int i = 0; i < source.length; i++) {
			min = i;
			for (int j = i + 1; j < source.length; j++) {
				if (a[j] < a[min])
					min = j;
			}
			swap(i, min);
		}
	}

	public void insertSort(int[] source) {
		for (int i = 1; i < source.length; i++) {
			for (int j = i; (j > 0) && (source[j] < source[j - 1]); j--) {
				swap(j, j - 1);
			}
		}
	}

}
