package com.twoPointers;

public class MaxConsecutiveOnesII {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 1, 0, 0, 1, 1, 1, 0 };

		System.out.println(new MaxConsecutiveOnesII().consecutiveOnes(nums));
	}

	private int consecutiveOnes(int[] nums) {

		int i = 0;
		int j = 0;
		int res = 0;
		int cnt = 0;

		while (j < nums.length) {

			if (nums[j] == 0) {
				cnt = j - i;
				i = j;
			} else
				cnt++;

			j++;
			res = Math.max(res, cnt);
		}

		return res;
	}

}
