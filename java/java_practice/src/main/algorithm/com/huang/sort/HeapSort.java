package com.huang.sort;

public class HeapSort {
	private int[] array;
	private int currentIndex;
	private int maxSize;

	public HeapSort(int size) {
		maxSize = size;
		array = new int[maxSize];
		currentIndex = 0;
	}

	// ������������ź���
	public void insertSort(int[] source) {
		for (int i = 0; i < source.length; i++) {
			array[currentIndex] = source[i]; // ���뵽�ڵ�β
			tickedUp(currentIndex++); // ���������ź���ʹ������ѵ�����
		}
	}

	private void tickedUp(int index) {
		int parentIndex = (index - 1) / 2; // ���ڵ������
		int temp = array[index]; // ���¼ӵ�β�ڵ����temp��
		while (index > 0 && array[parentIndex] < temp) {
			array[index] = array[parentIndex];
			index = parentIndex;
			parentIndex = (index - 1) / 2;
		}
		array[index] = temp;
	}

	// ȡ�����ֵ
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