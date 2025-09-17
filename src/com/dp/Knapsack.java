package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Knapsack {

	static int[][] dp = null;
	static int weight = 0;

	static int knapSack(int W, int wt[], int val[]) {

		dp = new int[wt.length][W + 1];

		for (int i = 0; i < wt.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		return knapSack(wt.length - 1, W, wt, val);

	}

	static int knapSackIterative(int W, int wt[], int val[]) {

		dp = new int[wt.length][W + 1];

		dp[0][W] = val[0];

		for (int i = 1; i < dp.length; i++) {

			for (int k = W; k >= 0; i++) {

				int a = dp[i - 1][k];// not include

				if (k >= wt[i]) {
					a = Math.max(a, dp[i - 1][k - wt[i]] + val[i]);// include
				}

				dp[i][k] = a;
			}
		}

		return dp[wt.length - 1][W];
	}

	static int knapSack(int i, int W, int wt[], int val[]) {

		if (i < 0 || W == 0) {
			return 0;
		}

		if (dp[i][W] != -1) {
			return dp[i][W];
		}

		int l = knapSack(i - 1, W, wt, val);

		if (W >= wt[i])
			l = Math.max(knapSack(i - 1, W - wt[i], wt, val) + val[i], l);

		dp[i][W] = l;

		return dp[i][W];
	}

//greedy
	class Item {
		int wt;
		int val;
		public double ratio;

		public Item(int wt, int val, double ratio) {
			this.wt = wt;
			this.val = val;
			this.ratio = ratio;
		}

		public Double getRatio() {
			return this.ratio;
		}

		@Override
		public String toString() {
			return "{wt=" + wt + ", val=" + val + ", ratio=" + ratio + "}";
		}
	}

	public static void main(String[] args) {
		int[] wts = new int[] { 20, 10, 30, 40 };
		int[] val = new int[] { 100, 60, 120, 150 };
		int knapSack = knapSack(50, wts, val);
		System.out.println(knapSack);
		new Knapsack().run();
	}

	public void run() {

		int[] wts = new int[] { 20, 10, 30, 40 };
		int[] val = new int[] { 100, 60, 120, 150 };
		int k = 50;

		List<Item> items = new ArrayList<>();

		for (int i = 0; i < wts.length; i++) {
			Item item = new Item(wts[i], val[i], (double) val[i] / wts[i]);
			items.add(item);
		}

		items = items.stream().sorted((a, b) -> Double.compare(b.ratio, a.ratio)).collect(Collectors.toList());

		int weightTotal = 0;
		double valueTotal = 0;

		for (Item item : items) {
			if (weightTotal + item.wt <= k) {
				// Take the whole item
				weightTotal += item.wt;
				valueTotal += item.val;
			} else {
				// Take the fraction of the item that fits
				int remainingCapacity = k - weightTotal;
				valueTotal += item.ratio * remainingCapacity;
				weightTotal += remainingCapacity;
				break; // Knapsack is full
			}
		}

		System.out.println(valueTotal);

	}
}
