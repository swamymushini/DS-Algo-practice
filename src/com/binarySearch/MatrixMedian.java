package com.binarySearch;

//Pending
public class MatrixMedian {

	public static void main(String[] args) {

		int[][] A = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };

		System.out.println(new MatrixMedian().findMedian(A));
		
//		System.out.println(new MatrixMedian().getSmallestCount(new int[] {1,5,10,11,14,15,17},15));

	}

	public int findMedian(int[][] A) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		int m = A.length;
		int n = A[0].length;

		int p = ((m * n) >>1)+1;

		for (int i = 0; i < m; i++) {
			min = Math.min(A[i][0], min);
			max = Math.max(A[i][n - 1], max);
		}

		int l = min, r = max;

		int ans = 0;
		while (l <= r) {

			int mid = (l + r) / 2;

			int cnt = 0;

			for (int i = 0; i < m; i++)
				cnt += getSmallestCount(A[i], mid);

			if (cnt < p) {
				l = mid + 1;
			} else {
				r = mid - 1;
				ans = mid;
			}
		}

		return ans;
	}

	public int getSmallestCount(int[] row, int mid) {
		int low = 0;
		int high = row.length - 1;
		while (low <= high) {
			int midd = low + (high - low) / 2;
			if (row[midd] <= mid) {
				low = midd + 1;
			} else {
				high = midd - 1;
			}
		}
		return low;
	}
}
