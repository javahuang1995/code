package com.huang.sort;

public class QuickSort {

	public void quickSort(int[] a) {
		recQuickSort(a, 0, a.length - 1);
	}

	public void recQuickSort(int[] a, int left, int right) {
		if (right - left <= 0) {
			return;
		} else {
			int pivot = a[right]; // 保存最右边的值，以这个值作为划分点
			int partition = partitionIt(a, left, right, pivot);// 将数组划分两部分，并将划分点的值放在正确位置，并返回该位置
			recQuickSort(a, left, partition - 1);// 调用自身对左边进行排序
			recQuickSort(a, partition + 1, right);// 调用自身对右边进行排序
		}
	}

	public int partitionIt(int[] a, int left, int right, int pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while (true) {
			while (a[++leftPtr] < pivot) {
			} // 往上找
			while (rightPtr > 0 && a[--rightPtr] > pivot) {
			} // 往下找
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);// 将划分放在正确的位置
		return leftPtr;// 返回划分点，用于再次小范围划分
	}

	public void quickSort2(int[] a) {
		recQuickSort2(a, 0, a.length - 1);
	}

	public void recQuickSort2(int[] a, int left, int right) {
		int size = right - left + 1;
		if (size <= 3) {
			manualSort(a, left, right);// 数据项小于等于3个，直接排
		} else {
			long median = medianOf3(a, left, right);// 取左边、右边和中间三个数中中等大小的数作为枢纽
			int partition = partitionIt2(a, left, right, median);// 将枢纽放到正确的位置
			recQuickSort2(a, left, partition - 1);// 调用自身对左边进行排序
			recQuickSort2(a, partition + 1, right);// 调用自身对右边进行排序
		}
	}

	private void manualSort(int[] a, int left, int right) {
		int size = right - left + 1;
		if (size <= 1) {
			return; // 1个不用排
		}
		if (size == 2) {
			if (a[left] > a[right]) { // 2个很好排
				swap(left, right);
			}
			return;
		} else { // 3个比较下就可以排好了
			int center = right - 1;
			if (a[left] > a[center]) {
				swap(left, center);
			}
			if (a[left] > a[right]) {
				swap(left, right);
			}
			if (a[center] > a[right]) {
				swap(center, right);
			}
		}
	}

	private long medianOf3(int[] a, int left, int right) {
		int center = (left + right) / 2;
		if (a[left] > a[center]) {
			swap(left, center);
		}
		if (a[left] > a[right]) {
			swap(left, right);
		}
		if (a[center] > a[right]) {
			swap(center, right);
		} // 已经将三个排好序
		swap(center, right - 1); // 然后将枢纽保存在right-1位置
		return a[right - 1];// 这保证了首位置比枢纽值小，最末尾位置比枢纽值大
	}

	public int partitionIt2(int[] a, int left, int right, long pivot) {
		int leftPtr = left;
		int rightPtr = right - 1;
		while (true) {
			while (a[++leftPtr] < pivot) {
			} // 往上找
			while (a[--rightPtr] > pivot) {
			} // 往下找
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right - 1);// 把right-1处存放的枢纽放到正确位置
		return leftPtr;// 返回划分点，用于再次小范围划分
	}

	public void quickSort3(int[] a) {
		recQuickSort3(a, 0, a.length - 1);
	}

	public void recQuickSort3(int[] a, int left, int right) {
		int size = right - left + 1;
		if (size < 10) {
			insertionSort(a, left, right);// 小于10项使用插入排序
		} else { // 大于10项使用快速排序
			long median = medianOf3(a, left, right);
			int partition = partitionIt2(a, left, right, median);// 上面的partionIt2方法
			recQuickSort3(a, left, partition - 1);
			recQuickSort3(a, partition + 1, right);
		}
	}

	private void insertionSort(int[] a, int left, int right) {
		for (int i = left + 1; i <= right; i++) {
			for (int j = i; (j > left) && (a[j] < a[j - 1]); j--) {
				swap(j, j - 1);
			}
		}
	}

}
