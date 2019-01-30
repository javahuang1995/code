package com.huang.sort;

public class QuickSort {

	public void quickSort(int[] a) {
		recQuickSort(a, 0, a.length - 1);
	}

	public void recQuickSort(int[] a, int left, int right) {
		if (right - left <= 0) {
			return;
		} else {
			int pivot = a[right]; // �������ұߵ�ֵ�������ֵ��Ϊ���ֵ�
			int partition = partitionIt(a, left, right, pivot);// �����黮�������֣��������ֵ��ֵ������ȷλ�ã������ظ�λ��
			recQuickSort(a, left, partition - 1);// �����������߽�������
			recQuickSort(a, partition + 1, right);// ����������ұ߽�������
		}
	}

	public int partitionIt(int[] a, int left, int right, int pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;
		while (true) {
			while (a[++leftPtr] < pivot) {
			} // ������
			while (rightPtr > 0 && a[--rightPtr] > pivot) {
			} // ������
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);// �����ַ�����ȷ��λ��
		return leftPtr;// ���ػ��ֵ㣬�����ٴ�С��Χ����
	}

	public void quickSort2(int[] a) {
		recQuickSort2(a, 0, a.length - 1);
	}

	public void recQuickSort2(int[] a, int left, int right) {
		int size = right - left + 1;
		if (size <= 3) {
			manualSort(a, left, right);// ������С�ڵ���3����ֱ����
		} else {
			long median = medianOf3(a, left, right);// ȡ��ߡ��ұߺ��м����������еȴ�С������Ϊ��Ŧ
			int partition = partitionIt2(a, left, right, median);// ����Ŧ�ŵ���ȷ��λ��
			recQuickSort2(a, left, partition - 1);// �����������߽�������
			recQuickSort2(a, partition + 1, right);// ����������ұ߽�������
		}
	}

	private void manualSort(int[] a, int left, int right) {
		int size = right - left + 1;
		if (size <= 1) {
			return; // 1��������
		}
		if (size == 2) {
			if (a[left] > a[right]) { // 2���ܺ���
				swap(left, right);
			}
			return;
		} else { // 3���Ƚ��¾Ϳ����ź���
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
		} // �Ѿ��������ź���
		swap(center, right - 1); // Ȼ����Ŧ������right-1λ��
		return a[right - 1];// �Ᵽ֤����λ�ñ���ŦֵС����ĩβλ�ñ���Ŧֵ��
	}

	public int partitionIt2(int[] a, int left, int right, long pivot) {
		int leftPtr = left;
		int rightPtr = right - 1;
		while (true) {
			while (a[++leftPtr] < pivot) {
			} // ������
			while (a[--rightPtr] > pivot) {
			} // ������
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right - 1);// ��right-1����ŵ���Ŧ�ŵ���ȷλ��
		return leftPtr;// ���ػ��ֵ㣬�����ٴ�С��Χ����
	}

	public void quickSort3(int[] a) {
		recQuickSort3(a, 0, a.length - 1);
	}

	public void recQuickSort3(int[] a, int left, int right) {
		int size = right - left + 1;
		if (size < 10) {
			insertionSort(a, left, right);// С��10��ʹ�ò�������
		} else { // ����10��ʹ�ÿ�������
			long median = medianOf3(a, left, right);
			int partition = partitionIt2(a, left, right, median);// �����partionIt2����
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
