package com.hashing;

import java.util.HashMap;
import java.util.Map;

import com.util.Util;

public class LargestSequenceZeroSum {

	public static void main(String[] args) {
		int[] lszero = new LargestSequenceZeroSum().lszero(new int[] { 0, 22, 7, 21, -11, -6, -7, -16, -2  });
		Util.printArray(lszero);
	}

	public int[] lszero(int[] A) {

		int max = Integer.MIN_VALUE;
		int st = 0;
		int en = 0;

		Map<Long, Integer> map = new HashMap<>();

		map.put((long) A[0], 0);

		long[] arr = new long[A.length];

		for (int i = 0; i < A.length; i++) {
			
			if(i==0) 
				arr[0] = A[0];
			else
				arr[i] = arr[i - 1] + A[i];

			if (arr[i] == 0) {

				int len = i + 1;

				if (len > max) {
					st = -1;
					en = i;
					max = len;
				}

			}

			if (map.containsKey(arr[i])) {
				int len = i - map.get(arr[i]);

				if (len > max) {
					st = map.get(arr[i]);
					en = i;
					max = len;
				}

			} else
				map.put(arr[i], i);

		}

		return getSubArray(A, st, en);

	}

	private int[] getSubArray(int A[], int st, int en) {

		int[] arr = new int[en - st];

		for (int i = st + 1; i <= en; i++) {
			arr[i - (st + 1)] = A[i];

		}

		return arr;
	}
}
