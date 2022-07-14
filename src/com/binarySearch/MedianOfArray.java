package com.binarySearch;

import java.util.List;

import com.util.Util;

public class MedianOfArray {

	public static void main(String[] args) {
		double findMedianSortedArrays = new MedianOfArray().findMedianSortedArrays(
				Util.createArrayList(new int[] { 1, 4, 5 }), Util.createArrayList(new int[] { 6 }));

		System.out.println(findMedianSortedArrays);
	}

	int total = 0;

	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

		int m = a.size();
		int n = b.size();
		total = m + n;

		if (n < m) {
			return findMedian(0, n - 1, b, a);
		} else {
			return findMedian(0, m - 1, a, b);
		}

	}

	double findMedian(int l, int r, final List<Integer> a, final List<Integer> b) {
		
		int aMid = 0;
		
		if(l<=r) {
			 aMid = (l + r) / 2;
		}else if(r<0)
			 aMid =  -1;
		else 
			aMid = a.size();

		int bMid = (total / 2) - (aMid + 1) - 1;

		int aLeft = aMid >= 0 ? a.get(aMid) : Integer.MIN_VALUE;
		int aRight = aMid < a.size() - 1 ? a.get(aMid + 1) : Integer.MAX_VALUE;

		int bLeft = bMid >= 0 ? b.get(bMid) : Integer.MIN_VALUE;
		int bRight = bMid < b.size() - 1 ? b.get(bMid + 1) : Integer.MAX_VALUE;

		if (bLeft <= aRight && aLeft <= bRight) {

			int j = Math.min(aRight, bRight);

			if ((total & 1) == 0) {
				int i = Math.max(bLeft, aLeft);
				return (double) (i + j) / 2;
			} else
				return j;

		} else if (aLeft > bRight)
			return findMedian(l, aMid - 1, a, b);
		else
			return findMedian(aMid + 1, r, a, b);

	}
}
