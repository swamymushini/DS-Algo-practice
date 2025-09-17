package com.arrays;

public class MaximumStockPrice {

	static int[] p = new int[] { 7, 1, 5, 3, 6, 4, 8, 12, 15, 9 };

	public static void main2(String[] args) {

		int l = 0;
		int r = 1;
		int len = p.length;
		int result = 0;
		while (r < len) {
			if (p[l] > p[r]) {
				l++;
				r++;
				continue;
			}

			if (r < len && p[r] > p[r + 1]) {
				result = result + p[r] - p[l];
				l = r + 1;
				r = r + 2;
			} else {
				r++;
			}
		}

	}

	public static void main(String[] args) {
		int maxProfit = new MaximumStockPrice().maxProfit2(new int[] { 3,3,5,0,0,3,1,4 });
		System.out.println(maxProfit);
	}

	public int maxProfit(int[] p) {
		int l = 0;
		int r = 1;
		int len = p.length;
		int res = 0;
		int sell = 0;

		while (r < len) {

			if (p[r] <= p[l]) {
				l = r;
				r++;
				sell = 0;
				continue;
			}

			if (p[r] > sell) {
				int pf = p[r] - p[l];
				res = Math.max(pf, res);
				sell = p[r];
			} else if (p[l] >= p[r]) {
				sell = 0;
				l = r;
			}
			r++;

		}

		return res;
	}

	public int maxProfit2(int[] p) {
		int l = 0;
		int r = 1;
		int len = p.length;
		int res = 0;

		while (r < len) {

			if (p[l] < p[r]) {
				int pf = p[r] - p[l];
				res = Math.max(pf, res);
			} else {
				l = r;
			}
			r++;

		}

		return res;
	}

}
