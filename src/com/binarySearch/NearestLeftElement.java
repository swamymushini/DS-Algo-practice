package com.binarySearch;

public class NearestLeftElement {
	public static void main(String[] args) {
		System.out.println(new NearestLeftElement().nearestSmallLeft(new int[] { 1, 3, 4, 6, 8, 9, 10, 15 }, 6));
	}

	public int nearestSmallLeft(int[] a, int target) {

		int l = 0;
		int r = a.length - 1;
		int res = 0;
		while (l <= r) {
			int mid = (l + r) / 2;

			if (a[mid] > target) {
				r = mid - 1;
			} else {
				res = Math.max(res, mid);
				l = mid + 1;
			}
		}

		return a[res];
	}

}
