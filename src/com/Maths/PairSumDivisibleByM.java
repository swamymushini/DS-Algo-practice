package com.Maths;

import java.util.HashMap;
import java.util.Map;

public class PairSumDivisibleByM {

	public static void main(String[] args) {
		System.out.println(new PairSumDivisibleByM().solve(new int[] { 1, 2, 3, 4, 5 }, 2));
	}

	public int solve(int[] A, int B) {

		int sum = 0;

		int mod = (int) Math.pow(10, 9) + 7;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {

			A[i] %= B;

			if (!map.containsKey(A[i]))
				map.put(A[i], 0);

			map.put(A[i], map.get(A[i]) + 1);
		}

		if (map.containsKey(0)) {
			sum += map.get(0);
		}

		int i = 1;

		while (i <= B / 2) {

			if (!map.containsKey(i) || !map.containsKey(B - i)) {
				i++;
				continue;
			}

			long val = map.get(i) * map.get(B - i);

			val %= mod;

			sum += (int) val;

			i++;
		}

		return sum % mod;

	}

}
