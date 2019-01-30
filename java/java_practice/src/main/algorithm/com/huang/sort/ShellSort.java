package com.huang.sort;

public class ShellSort {

	public

			void shellSort2() {

		int h = 1;

		while (h <= nElem / 3) {
			h = h * 3 + 1;
			// 增量间隔
		}

		while (h > 0) {

			for (int i = h; i < nElem; i++) {

				// 每个增量间隔内，实现插入排序，两个for循环和插入排序一样，只不过第二个for循环里参数略有调整而已，和h有关

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
