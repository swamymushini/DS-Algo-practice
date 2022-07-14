package com.arrays;

import java.util.ArrayList;

public class QueryPrefixSum {

	private int getMod(long num) {
		long mod = 1000000007;

		long res = num % mod;

		if (res < 0) {
			return (int) ((res + mod) % mod);
		}

		return (int) res;
	}

	public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C,
			ArrayList<Integer> D, ArrayList<Integer> E) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < A.size(); i++) {

			ArrayList<Integer> arr = A.get(i);

			for (int j = 1; j < A.get(0).size(); j++) {

				long sum = arr.get(j - 1);

				sum = getMod(sum);

				sum += arr.get(j);
				sum = getMod(sum);

				arr.set(j, (int) sum);
			}
		}

		for (int j = 0; j < A.get(0).size(); j++) {

			for (int i = 1; i < A.size(); i++) {

				long sum = A.get(i - 1).get(j);

				sum = getMod(sum);

				sum += A.get(i).get(j);

				sum = getMod(sum);

				A.get(i).set(j, (int) sum);
			}
		}

		int k = -1;

		while (++k < B.size()) {

			int a1 = B.get(k) - 1;
			int b1 = C.get(k) - 1;

			int a2 = D.get(k) - 1;
			int b2 = E.get(k) - 1;

			long sum = A.get(a2).get(b2);

			sum = getMod(sum);

			if (a1 - 1 >= 0)
				sum -= A.get(a1 - 1).get(b2);

			sum = getMod(sum);

			if (b1 - 1 >= 0)
				sum -= A.get(a2).get(b1 - 1);

			sum = getMod(sum);

			if ((a1 - 1 >= 0) && (b1 - 1 >= 0))
				sum += A.get(a1 - 1).get(b1 - 1);

			sum = getMod(sum);

			res.add((int) sum);

		}

		return res;
	}
}
