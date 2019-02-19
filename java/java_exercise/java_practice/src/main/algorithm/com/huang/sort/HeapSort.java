package com.huang.sort;

import java.util.Arrays;

/**
 * 二叉堆排序
 * 
 * @author Administrator 其实就是构造一个二叉堆。就完事了。二叉堆本来就是有序的。
 *
 */
public class HeapSort {
	private int[] array;
	private int currentIndex;
	private int maxSize;

	public static void main(String[] args) {
		HeapSort heap = new HeapSort(50);
		int[] a = { 2, 3, 5, 1, 23, 6, 78, 34, 23, 4, 5, 78, 34, 65, 32, 65, 76, 32, 76, 1, 9 };
		heap.insertSort(a);
		System.out.println(Arrays.toString(a));
	}

	public HeapSort(int size) {
		maxSize = size;
		array = new int[maxSize];
		currentIndex = 0;
	}

	// 插入数据项，并排好序
	public void insertSort(int[] source) {
		for (int i = 0; i < source.length; i++) {
			array[currentIndex] = source[i]; // 插入到节点尾
			tickedUp(currentIndex++); // 向上重新排好序，使得满足堆的条件
		}
	}

	private void tickedUp(int index) {
		int parentIndex = (index - 1) / 2; // 父节点的索引
		int temp = array[index]; // 将新加的尾节点存在temp中
		while (index > 0 && array[parentIndex] < temp) {
			array[index] = array[parentIndex];
			index = parentIndex;
			parentIndex = (index - 1) / 2;
		}
		array[index] = temp;
	}

	// 取出最大值
	public int getMax() {
		int maxNum = array[0];
		array[0] = array[--currentIndex];
		trickleDown(0);
		return maxNum;
	}

	private void trickleDown(int index) {
		int top = array[index];
		int largeChildIndex;
		while (index < currentIndex / 2) { // while node has at least one child
			int leftChildIndex = 2 * index + 1;
			int rightChildIndex = leftChildIndex + 1;
			// find larger child
			if (rightChildIndex < currentIndex && // rightChild exists?
					array[leftChildIndex] < array[rightChildIndex]) {
				largeChildIndex = rightChildIndex;
			} else {
				largeChildIndex = leftChildIndex;
			}
			if (top >= array[largeChildIndex]) {
				break;
			}
			array[index] = array[largeChildIndex];
			index = largeChildIndex;
		}
		array[index] = top;
	}
}