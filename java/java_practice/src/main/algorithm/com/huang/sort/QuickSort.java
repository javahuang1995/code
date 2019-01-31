package com.huang.sort;

import java.util.Arrays;

/**
 * ��������
 * 
 * @author Administrator
 *
 */
public class QuickSort {
	public static void quickSort(int[] arr, int startIndex, int endIndex) {
		// �ݹ����������startIndex�����endIndex��ʱ��
		if (startIndex >= endIndex) {
			return;
		}
		// �õ���׼Ԫ��λ��
		int pivotIndex = partition2(arr, startIndex, endIndex);
		// �÷��η��ݹ����е�������
		quickSort(arr, startIndex, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, endIndex);
	}

	/**
	 * ��ӷ�
	 * 
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private static int partition(int[] arr, int startIndex, int endIndex) {
		// ȡ��һ��λ�õ�Ԫ����Ϊ��׼Ԫ��
		int pivot = arr[startIndex];

		int left = startIndex;
		int right = endIndex;
		// �ӵ�λ�ã���ʼ����pivot��λ��
		int index = startIndex;

		// ��ѭ��������ָ���غϻ��߽���ʱ����
		while (right >= left) {
			// rightָ�����������бȽ�
			while (right >= left) {
				if (arr[right] < pivot) {
					arr[left] = arr[right];
					index = right;// ��Ϊ�µĿ�
					left++;// left�����ƶ�
					break;
				}
				right--;
			}
			// leftָ��������ҽ��бȽ�
			while (right >= left) {
				if (arr[left] > pivot) {
					arr[right] = arr[left];
					index = left;// ��Ϊ�µĿ�
					right--;// right�����ƶ�
					break;
				}
				left++;
			}
		}
		arr[index] = pivot;// �������һ����
		return index;
	}

	/**
	 * ָ�뽻����
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private static int partition2(int[] arr, int startIndex, int endIndex) {
		// ȡ��һ��λ�õ�Ԫ����Ϊ��׼Ԫ��
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;

		while (left != right) {
			// ����rightָ��Ƚϲ�����
			while (left < right && arr[right] > pivot) {
				right--;
			}
			// ����rightָ��Ƚϲ�����
			while (left < right && arr[left] <= pivot) {
				left++;
			}
			// ����left��rightָ���Ԫ��
			if (left < right) {
				int p = arr[left];
				arr[left] = arr[right];
				arr[right] = p;
			}
		}

		// pivot��ָ���غϵ㽻��
		int p = arr[left];
		arr[left] = arr[startIndex];
		arr[startIndex] = p;

		return left;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 7, 6, 5, 3, 2, 8, 1 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
}
