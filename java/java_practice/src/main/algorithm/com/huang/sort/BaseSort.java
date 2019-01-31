package com.huang.sort;

/**
 * ð������ ѡ������ ��������
 * ѡ������Ҳ�ͽ����ˣ�����һŪ��û�и�����أ� ��ô�ã���ʱ�����ܽ������ǵ������ˣ����ص㣩��
 * ��1��ð�������ǱȽ�����λ�õ�����������ѡ�������ǰ�˳��Ƚϣ������ֵ������Сֵ��
 * ��2��ð������ÿһ�ֱȽϺ�λ�ò��Զ���Ҫ��λ�ã�ѡ������ÿһ�ֱȽ϶�ֻ��Ҫ��һ��λ�ã� ��3��ð��������ͨ����ȥ��λ�ã�ѡ�������Ǹ���λ��ȥ������
 * ð��������ȱ�㣺�ŵ�:�Ƚϼ򵥣��ռ临�ӶȽϵͣ����ȶ��ģ� ȱ��:ʱ�临�Ӷ�̫�ߣ�Ч������ ѡ��������ȱ�㣺�ŵ㣺һ�ֱȽ�ֻ��Ҫ��һ��λ�ã�
 * ȱ�㣺Ч���������ȶ����ٸ�����5��8��5��2��9 ����֪����һ��ѡ���һ��Ԫ��5���2��������ôԭ������2��5�����λ��ǰ��˳����ƻ��ˣ���
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
	 * ð������
	 * 
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		for (int i = a.length - 1; i > 0; i--) // ���Ƚ�N-1��
		{
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1])
					swap(a, j, j + 1); // ����������ʵ����
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
	 * ѡ������
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
			swap(a, i, min);// ��������ѭ��������档
		}
	}

	/**
	 * ��������
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
