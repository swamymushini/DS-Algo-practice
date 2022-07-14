package com.binarySearch;

public class RotatedSortedArraySearch {
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

	public static void main(String[] args) {
		int solve = new RotatedSortedArraySearch().search(new int[] { 180, 181, 182, 183, 184, 187, 188, 189, 191, 192,
				193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29,
				32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78,
				79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116,
				118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155,
				156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177 }, 145);

		System.out.println(solve);
	}

	public int search(final int[] A, int B) {

		int l = 0;
		int r = A.length - 1;
		int sep = 0;

		if (r == 0)
			return A[0];

		while (l <= r) {

			int mid = (l + r) / 2;

			if (A[mid] > A[mid + 1]) {
				sep = mid;
				break;
			} else if (A[mid] < A[0])
				r = mid - 1;
			else
				l = mid + 1;

		}

		if (B >= A[0]) {
			l = 0;
			r = sep;
		} else if (B <= A[A.length - 1]) {
			l = sep + 1;
			r = A.length - 1;
		} else
			return -1;

		while (l <= r) {
			int mid = (l + r) / 2;

			if (A[mid] == B) {
				return mid;
			} else if (A[mid] < B) {
				l = mid + 1;
			} else
				r = mid - 1;

		}

		return -1;
	}
}
