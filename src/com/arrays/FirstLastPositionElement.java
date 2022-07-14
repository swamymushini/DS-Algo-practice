package com.arrays;

public class FirstLastPositionElement {

	public static void main(String[] args) {
		new FirstLastPositionElement().searchInsert(new int[] { 1, 5, 5, 8, 8, 8, 8, 10 }, 1);
	}

	public int[] searchInsert(int[] nums, int target) {
		int left = leftBinarySearch(nums, 0, nums.length - 1, target);
		int right = rightBinarySearch(nums, 0, nums.length - 1, target);

		return new int[] { left, right };

	}

	int rightBinarySearch(int[] nums, int l, int r, int tar) {
		if (r >= l) {

			int mid = l + (r - l) / 2;

			if (nums[mid] == tar) {

				if (mid == nums.length - 1) {
					return mid;
				} else if (nums[mid + 1] != tar) {
					return mid;
				}
				return rightBinarySearch(nums, mid + 1, r, tar);

			} else if (tar > nums[mid]) {
				return rightBinarySearch(nums, mid + 1, r, tar);
			} else if (tar < nums[mid]) {
				return rightBinarySearch(nums, l, mid - 1, tar);
			}

		}

		return -1;
	}

	int leftBinarySearch(int[] nums, int l, int r, int tar) {
		if (r >= l) {

			int mid = l + (r - l) / 2;

			if (nums[mid] == tar) {

				if (mid == 0) {
					return mid;
				} else if (nums[mid - 1] != tar) {
					return mid;
				}
				return leftBinarySearch(nums, l, mid - 1, tar);

			} else if (tar > nums[mid]) {
				return leftBinarySearch(nums, mid + 1, r, tar);
			} else if (tar < nums[mid]) {
				return leftBinarySearch(nums, l, mid - 1, tar);
			}

		}

		return -1;
	}

}
