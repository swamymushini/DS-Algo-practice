package com.binarySearch;

public class SortedInsertPosition {

	public static void main(String[] args) {
		System.out.println(new SortedInsertPosition().searchInsert(new int[] { 1, 5, 7, 8 }, -1));

	}

	public int searchInsert(int[] A, int B) {

		int l = 0;

		int r = A.length - 1;

		while (l < r) {

			int mid = l + (r - l) / 2;

			if (A[mid] < B) {
				l = mid + 1;
			} else if (A[mid] > B) {
				r = mid - 1;
			} else {
				return mid;
			}

		}

		return l;
	}
}
