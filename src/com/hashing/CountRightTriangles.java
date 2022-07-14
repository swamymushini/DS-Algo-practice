package com.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountRightTriangles {

	public static void main(String[] args) {
		System.out.println(new CountRightTriangles().solve(new int[] { 1, 1, 2, 3, 3 }, new int[] { 1, 2, 1, 2, 1 }));
	}

	public int solve(int[] A, int[] B) {

		long count = 0;
		int mod = (int) Math.pow(10, 9);

		Map<Integer, Integer> xMap = new HashMap<>();
		Map<Integer, Integer> yMap = new HashMap<>();

		for (int i = 0; i < A.length; i++) {

			int k = xMap.getOrDefault(A[i], 0);
			xMap.put(A[i], k + 1);

			k = yMap.getOrDefault(B[i], 0);
			yMap.put(B[i], k + 1);

		}
		

		for (int i = 0; i < A.length; i++) {

			int x = A[i];
			int y = B[i];
			long baseCount = 0;
			long attCount = 0;

			if (yMap.containsKey(y)) {
				baseCount = yMap.get(y) - 1;
			}

			if (xMap.containsKey(x)) {
				attCount = xMap.get(x)-1;
			}

			count = count+baseCount * attCount;
			count = count % mod;

		}

		count = count % mod;

		return ((int) count);
	}

}
