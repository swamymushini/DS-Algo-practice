package com.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonElements {

	public int[] solve(int[] A, int[] B) {

		Map<Integer, Integer> xMap = new HashMap<>();
		Map<Integer, Integer> yMap = new HashMap<>();

		for (int i = 0; i < A.length; i++) {

			int k = xMap.getOrDefault(A[i], 0);
			xMap.put(A[i], k + 1);
		}

		for (int i = 0; i < B.length; i++) {

			int k = yMap.getOrDefault(B[i], 0);
			yMap.put(B[i], k + 1);
		}

		ArrayList<Integer> arr = new ArrayList<>();

		for (Map.Entry<Integer, Integer> m : xMap.entrySet()) {

			int k = m.getKey();

			int cnt = m.getValue();

			if (yMap.containsKey(k)) {
				int val = yMap.get(k);
				int j = Math.min(cnt, val);

				while (j-- > 0) {
					arr.add(k);
				}

			}
		}

		return arrayListtoArray(arr);
	}

	public static int[] arrayListtoArray(ArrayList<Integer> arr) {

		int[] arr1 = new int[arr.size()];

		for (int j = 0; j < arr.size(); j++) {
			arr1[j] = arr.get(j);
		}

		return arr1;
	}
}
