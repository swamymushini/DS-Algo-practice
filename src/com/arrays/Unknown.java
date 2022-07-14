package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class Unknown {

	public static void main(String[] args) {
		System.out.println(new Unknown().lszero(new int[] { 0, 22, 7, 21, -11, -6, -7, -16, -2 }));
	}

	public int[] lszero(int[] A) {

		Map<Integer, Integer> map = new HashMap<>();

		int start = 0;
		int end = 0;

		// map.put(0, -1);

		int[] B = new int[A.length];
		B[0] = A[0];
		map.put(B[0], 0);

		for (int i = 1; i < A.length; i++) {

			B[i] = A[i] + B[i - 1];

			if (map.containsKey(B[i])) {

				int val = map.get(B[i]);

				if ((i - val) > (end - start)) {
					start = val + 1;
					end = i + 1;
				}

			} else if (B[i] == 0) {

				if (i + 1 > (end - start)) {
					start = 0;
					end = i + 1;
				}

			} else {
				map.put(B[i], i);
			}

		}

		// System.out.println(start+" "+ end);

		if (end - start == 0) {
			return new int[] {};
		}

		int[] res = new int[end - start];
		int j = 0;

		for (int i = start; i < end; i++) {
			res[j++] = A[i];
		}

		return res;
	}
}
