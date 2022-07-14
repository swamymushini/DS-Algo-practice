package com.arrays;

public class OddandEvenEqualSum {

	public static void main(String[] args) {

		int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 13, 1, 2, 3, 4, 5, 6 };

		int ln = arr.length;

		int[] pref = new int[ln];

		int[] podd = new int[ln];

		pref[0] = arr[0];
		podd[0] = 0;
		int cnt = 0;

		for (int i = 1; i < ln; i++) {

			if (i % 2 == 0) {
				pref[i] = arr[i] + pref[i - 1];
				podd[i] = podd[i - 1];
			} else {
				pref[i] = pref[i - 1];
				podd[i] = arr[i] + podd[i - 1];
			}
		}

		for (int i = 0; i < ln; i++) {

			if (i == 0) {
				if ((pref[ln - 1] - pref[i]) == (podd[ln - 1] - podd[i])) {
					cnt++;
				}
				continue;
			}

			int evenSum = pref[i - 1] + podd[ln - 1] - podd[i];
			int oddSum = podd[i - 1] + pref[ln - 1] - pref[i];

			if (oddSum == evenSum) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
