package com.dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int len = new LongestIncreasingSubsequence().lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 });
		System.out.println(len);
	}

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int length = 0;

		for (int num : nums) {
			int index = binarySearch(dp, 0, length, num);

			dp[index] = num;

			System.out.println(dp[index]);

			if (index == length) {
				length++;
			}
		}

		return length;
	}

	private int binarySearch(int[] dp, int start, int end, int target) {

		while (start < end) {
			int mid = start + (end - start) / 2;

			if (dp[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return start;
	}
}