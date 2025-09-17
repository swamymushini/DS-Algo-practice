package com.binarySearch;

public class MedianOfTwoArrays2A {

	public static void main(String[] args) {

		double findMedianSortedArrays = new MedianOfTwoArrays2A().findMedianSortedArrays(new int[] {},
				new int[] { 2, 3 });

		System.out.println(findMedianSortedArrays);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int total = nums1.length + nums2.length;
		int l = 0;
		int r = nums1.length - 1;
		int hlf = total / 2;
		while (true) {
			int aMid = l + (r - l) / 2;
			int bMid = hlf - aMid - 2;

			int aL = aMid >= 0 ? nums1[aMid] : Integer.MIN_VALUE;
			int aR = aMid + 1 < nums1.length ? nums1[aMid + 1] : Integer.MAX_VALUE;

			int bL = bMid >= 0 ? nums2[bMid] : Integer.MIN_VALUE;
			int bR = (bMid + 1 < nums2.length) && (bMid + 1 >= 0) ? nums2[bMid + 1] : Integer.MAX_VALUE;

			if (aL <= bR && bL <= aR) {
				if (total % 2 == 0) {
					int m1 = Math.max(aL, bL);
					int m2 = Math.min(aR, bR);
					return ((double) (m1 + m2) / 2);
				} else {
					return (double) (Math.min(aR, bR));
				}
			} else if (aL > bR) {
				r = aMid - 1;
			} else {
				l = aMid + 1;
			}
		}
	}
}
