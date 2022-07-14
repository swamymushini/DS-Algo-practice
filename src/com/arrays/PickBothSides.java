package com.arrays;

public class PickBothSides {

	public static void main(String[] args) {
		System.out
				.println(solve(
						new int[] { -969, -948, 350, 150, -59, 724, 966, 430, 107, -809, -993, 337, 457, -713, 753,
								-617, -55, -91, -791, 758, -779, -412, -578, -54, 506, 30, -587, 168, -100, -409, -238,
								655, 410, -641, 624, -463, 548, -517, 595, -959, 602, -650, -709, -164, 374, 20, -404,
								-979, 348, 199, 668, -516, -719, -266, -947, 999, -582, 938, -100, 788, -873, -533, 728,
								-107, -352, -517, 807, -579, -690, -383, -187, 514, -691, 616, -65, 451, -400, 249,
								-481, 556, -202, -697, -776, 8, 844, -391, -11, -298, 195, -515, 93, -657, -477, 587 },
						81));
	}

	static int solve(int[] arr, int B) {

		int n = arr.length;

		int[] pref = new int[n];
		int[] suff = new int[n];

		pref[0] = arr[0];
		suff[n - 1] = arr[n - 1];

		for (int i = 1; i < n; i++) {

			pref[i] = arr[i] + pref[i - 1];
			int j = n - i - 1;
			suff[j] = suff[j + 1] + arr[j];
		}

		int l = -1, m = B;

		// [5,3,6,7,9]
		// [9,4,6,3,2]

		int max = Integer.MIN_VALUE;

		while (l < B) {

			if (m == 0)
				max = Math.max(pref[l], max);
			else if (l < 0)
				max = Math.max(suff[n - m], max);
			else
				max = Math.max(pref[l] + suff[n - m], max);

			l++;
			m--;
		}

		return max;
	}
}
