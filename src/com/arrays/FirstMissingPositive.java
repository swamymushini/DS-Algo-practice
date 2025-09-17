package com.arrays;

public class FirstMissingPositive {

//	Input: nums = [1,2,0]
//			Output: 3

	public static void main(String[] args) {
		int[] nums = { 1,2,3 };

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length) {
				swap(i, nums[i] - 1, nums);
			}
		}

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] != i + 1) {
				System.out.println(i + 1);
				return;
//				return i+1;
			}

		}

		System.out.println(nums.length);

	}

	static void swap(int i, int j, int[] nums) {

		if (nums[j] == j + 1)
			return;

		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

		if (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length)
			swap(i, nums[i] - 1, nums);

	}

}
