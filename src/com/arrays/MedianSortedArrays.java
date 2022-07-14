package com.arrays;

public class MedianSortedArrays {

	public static void main(String[] args) {
		System.out.println(new MedianSortedArrays().findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 1, 2 }));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;

		if (m + n == 0)
			return 0;

		double sol = 0;

		int[] a = new int[m + n];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < m || j < n) {

			if (j >= n) {
				a[k++] = nums1[i++];
				continue;
			}

			if (i >= m) {
				a[k++] = nums2[j++];
				continue;
			}

			if (nums1[i] < nums2[j]) {

				a[k++] = nums1[i++];

			} else if (nums1[i] > nums2[j]) {

				a[k++] = nums2[j++];

			} else {
				a[k++] = nums1[i++];
				a[k++] = nums2[j++];
			}

		}

		if ((m + n) % 2 == 0) {
			double kk = (double) a[(m + n) / 2 - 1] + a[(m + n) / 2];
			sol = kk / 2;

		} else
			sol = a[(m + n) / 2];

		return sol;

	}
}