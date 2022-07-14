package com.arrays;

public class InsertPosition {

	private int tar = 0;

	public static void main(String[] args) {
		new InsertPosition().searchInsert(new int[] { 1, 2, 3, 7, 9 },10);
	}

	public void searchInsert(int[] nums, int target) {
		tar = target;
		System.out.println(binarySearch(nums, 0, nums.length - 1));
	}

	int binarySearch(int[] nums, int l, int r) {

		int mid = l + (r - l) / 2;

		if (r >= l) {
			if (nums[mid] == tar) {
				return mid;
			} else if (tar > nums[mid]) {
				return binarySearch(nums, mid + 1, r);
			} else if (tar < nums[mid]) {
				return binarySearch(nums, l, mid - 1);
			}
		}
		return l;
	}

}
