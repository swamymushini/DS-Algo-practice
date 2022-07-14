package com.arrays;

public class LongestConsecutiveOnes {

	public static void main(String[] args) {
		System.out.println(new LongestConsecutiveOnes().solve("01"));
	}

	public int solve(String A) {

		int res = -1;

		int cnt = 0;
		int n = A.length();

		for (int i = 0; i < n; i++) {
			if (A.charAt(i) != '0') {
				cnt++;
			}
		}
		
		if(cnt==n)
			return cnt;

		for (int i = 0; i < n; i++) {

			if (A.charAt(i) == '0') {
				int l = 0;
				int r = 0;
				int j = i - 1;
				while (j >= 0 && A.charAt(j) != '0') {
					l++;
					j--;
				}

				j = i + 1;
				while (j < n && A.charAt(j) != '0') {
					r++;
					j++;
				}

				if (cnt > (r + l))
					res = Math.max(res, r + l + 1);
				else
					res = Math.max(res, r + l);

			}

		}

		return res;
	}
}
