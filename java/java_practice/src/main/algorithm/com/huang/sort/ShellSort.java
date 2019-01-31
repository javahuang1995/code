package com.huang.sort;

public class ShellSort {
	public static void main(String[] args) {
		int[] a = { 2, 3, 5, 1, 23, 6, 78, 34, 23, 4, 5, 78, 34, 65, 32, 65, 76, 32, 76, 1, 9 };
		sort(a);
		for (int i : a) {
			System.out.print(i+",");
		}
	}

	/**
	 * ϣ������
	 * @param arrays
	 * ��Ҫ���������
	 */
	public static void sort(int[] arrays) {
		if (arrays == null || arrays.length <= 1) {
			return;
		}
		// ����
		int incrementNum = arrays.length / 2;
		while (incrementNum >= 1) {
			for (int i = 0; i < arrays.length; i++) {
				// ���в�������
				for (int j = i; j < arrays.length - incrementNum; j = j + incrementNum) {
					if (arrays[j] > arrays[j + incrementNum]) {
						int temple = arrays[j];
						arrays[j] = arrays[j + incrementNum];
						arrays[j + incrementNum] = temple;
					}
				}
			}
			// �����µ�����
			incrementNum = incrementNum / 2;
		}
	}
}
