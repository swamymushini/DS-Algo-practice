package com.hashing;

import java.util.HashMap;
import java.util.Map;

import com.util.Util;

public class CompareSortedSubarrays {

	public static HashMap<Integer, Long> map = new HashMap<>();

	public static void main(String[] args) {
		Util.printArray(
				new CompareSortedSubarrays().solve(new int[] { 1, 7, 11, 8, 11, 7, 1 }, new int[][] { { 0, 2, 4, 6 }

				}));
	}

	private void setHash(int[] A) {
		int N = A.length;
		long range = 1000 * 1000 * 1000 * 1000;

		for (int i = 0; i < N; i++) {
			long hashValue = (long) (Math.random() * range + 1);

			if (!map.containsKey(A[i])) {
				map.put(A[i], hashValue);
			}
		}
	}

	public int[] solve(int[] A, int[][] B) {

		int[] res = new int[B.length];
		int k = 0;

		long[] arr = new long[A.length];
		Map<Integer,Long> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {

			long range = 1000 * 1000 * 1000 * 1000;

			long hashValue = (long) (Math.random() * range + 1);

			if (!map.containsKey(A[i])) {
				map.put(A[i],hashValue);
			}

			if (i > 0) {
				arr[i] = arr[i-1] + map.get(A[i]);
			} else {
				arr[0] = arr[0] + map.get(A[0]);
			}

		}

		for (int i = 0; i < B.length; i++) {

			int l1 = B[i][0];
			int r1 = B[i][1];
			int l2 = B[i][2];
			int r2 = B[i][3];

			if (r1 - l1 != r2 - l2) {
				res[k++] = 0;
				continue;
			}

			long sum1 = arr[r1];

			if (l1 != 0)
				sum1 = sum1 - arr[l1 - 1];

			long sum2 = arr[r2];

			if (l2 != 0)
				sum2 = sum2 - arr[l2 - 1];

			if (sum1 == sum2)
				res[k++] = 1;
			else
				res[k++] = 0;

		}

		return res;
	}

}
