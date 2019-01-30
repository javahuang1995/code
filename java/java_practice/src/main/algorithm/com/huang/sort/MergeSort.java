package com.huang.sort;

public class MergeSort {

	public void mergeSort(int[] source) {
		int[] workSpace = new int[source.length];
		recMergeSort(source, workSpace, 0, source.length - 1);
	}

	private void recMergeSort(int[] source, int[] workSpace, int lowerBound, int upperBound) {
		if (lowerBound == upperBound) {
			return;
		} else {
			int mid = (lowerBound + upperBound) / 2;
			recMergeSort(source, workSpace, lowerBound, mid); // ◊Û±ﬂ≈≈
			recMergeSort(source, workSpace, mid + 1, upperBound); // ”“±ﬂ≈≈
			merge(source, workSpace, lowerBound, mid + 1, upperBound);// πÈ≤¢
		}
	}

	private void merge(int[] a, int[] workSpace, int lowPtr, int highPtr, int upperBound) {
		int j = 0;
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int n = upperBound - lowerBound + 1;
		while (lowPtr <= mid && highPtr <= upperBound) {
			if (a[lowPtr] < a[highPtr]) {
				workSpace[j++] = a[lowPtr++];
			} else {
				workSpace[j++] = a[highPtr++];
			}
		}
		while (lowPtr <= mid) {
			workSpace[j++] = a[lowPtr++];
		}

		while (highPtr <= upperBound) {
			workSpace[j++] = a[highPtr++];
		}

		for (j = 0; j < n; j++) {
			a[lowerBound + j] = workSpace[j];
		}
	}
}
