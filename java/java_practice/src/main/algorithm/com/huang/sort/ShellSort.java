package com.huang.sort;

public class ShellSort {

	public

			void shellSort2() {

		int h = 1;

		while (h <= nElem / 3) {
			h = h * 3 + 1;
			// �������
		}

		while (h > 0) {

			for (int i = h; i < nElem; i++) {

				// ÿ����������ڣ�ʵ�ֲ�����������forѭ���Ͳ�������һ����ֻ�����ڶ���forѭ����������е������ѣ���h�й�

				for (int j = i; j < nElem; j += h) {

					for (int k = j; (k - h >= 0) && a[k] < a[k - h]; k -= h) {
						swap(k, k - h);
					}
				}
			}
			h = (h - 1) / 3;
		}
	}
}
