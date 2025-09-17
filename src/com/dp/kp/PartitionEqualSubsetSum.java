package com.dp.kp;

import com.util.Util;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		int[] nums = { 2, 5, 1, 3, 3, 4 };
		System.out.println(canPartition(nums)); // Output: true
	}

	public static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums)
			sum += num;

		if (sum % 2 != 0)
			return false; // If total sum is odd, can't partition

		int target = sum / 2;
		Boolean[][] dp = new Boolean[nums.length][target + 1];
		boolean canAchieveTarget = canAchieveTarget(0, target, nums, dp);
		Util.print2DArray(dp);
		return canAchieveTarget;
	}

	private static boolean canAchieveTarget(int index, int target, int[] nums, Boolean[][] dp) {
		if (target == 0)
			return true;
		if (index >= nums.length || target < 0)
			return false;

		if (dp[index][target] != null)
			return dp[index][target];

		// Choose or skip current element
		boolean include = canAchieveTarget(index + 1, target - nums[index], nums, dp);
		boolean exclude = canAchieveTarget(index + 1, target, nums, dp);

		dp[index][target] = include || exclude;
		return dp[index][target];
	}
}
