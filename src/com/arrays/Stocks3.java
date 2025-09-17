package com.arrays;

public class Stocks3 {

	private static int maxProfit;

	public static void main(String[] args) {
		maxProfit = new Stocks3().maxProfit(new int[] { 3,3,5,0,0,3,1,4 });
		System.out.println(maxProfit);
	}
//1590
	public int maxProfit(int[] p) {

		int[] lProfit = new int[p.length];
		int[] rProfit = new int[p.length];
		int lMin = p[0];

		for (int i = 1; i < p.length; i++) {
			lProfit[i] = Math.max(lProfit[i - 1], p[i] - lMin);
			lMin = Math.min(lMin, p[i]);
		}

		int rMAx = p[p.length - 1];
		for (int i = p.length - 2; i >= 0; --i) {
			rProfit[i] = Math.max(rProfit[i + 1], rMAx - p[i]);
			rMAx = Math.max(rMAx, p[i]);
		}

		int profit = rProfit[0];

		for (int i = 1; i < p.length; i++) {

			profit = Math.max(profit, rProfit[i] + lProfit[i - 1]);

		}

		return profit;

	}
}