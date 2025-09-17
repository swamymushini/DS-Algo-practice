package com.dp;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

	public static void main(String[] args) {
		System.out.println(new TargetSum().findTargetSumWays(
				new int[] { 17, 13, 31, 50, 8, 40, 5, 13, 20, 45, 18, 45, 0, 28, 31, 39, 23, 13, 24, 2 }, 35));
	}

	public int findTargetSumWays(int[] nums, int target) {
		Map<Integer, Integer> dp = new HashMap<>();
		return findTargetSumWays(0, nums, 0, dp, target);
	}

	public int findTargetSumWays(int index, int[] nums, int sum, Map<Integer, Integer> dp, int target) {

		if (index == nums.length) {
			return sum == target ? 1 : 0;
		}

		int count = findTargetSumWays(index + 1, nums, sum + nums[index], dp, target);
		count += findTargetSumWays(index + 1, nums, sum - nums[index], dp, target);
		
		
		return count;
	}
}
