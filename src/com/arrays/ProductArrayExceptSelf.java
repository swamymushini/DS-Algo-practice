package com.arrays;

class ProductArrayExceptSelf {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		new ProductArrayExceptSelf().productExceptSelf(nums);
	}

	public int[] productExceptSelf(int[] nums) {

		int n = nums.length;
		int[] prefix = new int[n];
		int[] suffix = new int[n];

		prefix[0] = nums[0];
		suffix[n - 1] = nums[n - 1];

		for (int i = 1; i < n; i++) {
			prefix[i] = prefix[i] * nums[i];
			suffix[n - 1 - i] = suffix[n - i] * nums[n - 1 - i];
		}

		for (int i = 0; i < n; i++) {

			int pref = i - 1 >= 0 ? prefix[i - 1] : 1;
			int sux = i + 1 < n ? suffix[i + 1] : 1;

			nums[i] = pref * sux;
		}

		return nums;

	}
}