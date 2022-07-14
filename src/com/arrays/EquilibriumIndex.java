package com.arrays;

public class EquilibriumIndex {

	public int solve(int[] arr) {

		int ln = arr.length;

		int[] pref = new int[ln];

		pref[0] = arr[0];

		for (int i = 1; i < ln; i++) {

			pref[i] = arr[i] + pref[i - 1];

		}

		for (int i = 0; i < ln; i++) {

			if (i == 0) {

				if (pref[ln - 1] - pref[i] == 0) {
					return 0;
				}

				continue;
			}

			if ((pref[ln - 1] - pref[i]) == pref[i - 1]) {
				return i;
			}

		}

		return -1;
	}

}
