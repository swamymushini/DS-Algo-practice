package com.binarySearch;

public class NearestRight {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3,5 };
		int target = 4;
//		System.out.println(new NearestLeftElement().nearestSmallLeft(arr, target));
//		System.out.println(new NearestRight().nearestSmallRight(arr, target));
		System.out.println(new NearestRight().nearestMinElement(arr, target));

	}

	public int nearestSmallRight(int[] a, int target) {

		int l = 0;
		int r = a.length - 1;
		int res = 0;

		while (l <= r) {

			int mid = (l + r) / 2;

			if (a[mid] < target) {
				l = mid + 1;
			} else {
				res = mid;
				r = mid - 1;
			}

		}

		return a[res];
	}

	public int nearestMinElement(int[] a, int target) {

		int l = 0;
		int r = a.length - 1;

		int mid = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;

			if (a[mid] <= target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}

		}

		return a[mid];
	}
}
