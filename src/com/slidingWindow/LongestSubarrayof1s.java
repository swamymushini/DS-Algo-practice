package com.slidingWindow;

public class LongestSubarrayof1s {

	private static int longestSubarray;

	public static void main(String[] args) {
		longestSubarray = new LongestSubarrayof1s().longestSubarray(new int[] { 0, 0, 0, 0, 0, 0, 0 }

		);
		System.out.println(longestSubarray);
	}

	int start = -1;

	public int longestSubarray(int[] nums) {

		int index = 0;
		int curr = 0;
		int max = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 0) {
				index = getZeroIndex(nums);
				curr = i - index - 1;
			} else {
				curr++;
			}

			max = Math.max(max, curr);
		}

		return max;
	}

	int getZeroIndex(int[] arr) {
		int prev = start;
		while (start < arr.length - 1) {
			start++;
			if (arr[start] == 0) {
				break;
			}
		}
		return prev;
	}

}
