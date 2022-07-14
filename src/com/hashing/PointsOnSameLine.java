package com.hashing;

import java.util.HashMap;
import java.util.Map;

//not solved by me
public class PointsOnSameLine {

	public static void main(String[] args) {
		int solve = new PointsOnSameLine().solve(new int[] { 1, 7, 11, 8, 11, 7, 1 }, new int[] { 0, 2, 4, 6 });
	}

	public int solve(int[] A, int[] B) {

		int res = 0;
		for (int i = 0; i < A.length; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int count = 1;
			String str = "";
			int cur_max = 0;
			for (int j = 0; j < A.length; j++) {
				if (i != j) {
					if (A[i] == A[j] && B[j] == B[i])
						count++;
					else {
						int numerator = B[i] - B[j];
						int denominator = A[i] - A[j];
						int gcd = findGCD(numerator, denominator);
						str = "" + (numerator / gcd) + "-" + (denominator / gcd);
						map.put(str, map.getOrDefault(str, 0) + 1);
					}
					cur_max = Math.max(cur_max, count);
					if (map.containsKey(str))
						cur_max = Math.max(cur_max, count + map.get(str));
				}
			}
			res = Math.max(res, cur_max);
		}
		return res;
	}

	int findGCD(int a, int b) {
		if (b == 0)
			return a;
		return findGCD(b, a % b);
	}

}
