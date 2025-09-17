package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {

		int[] nums = { 4, 4, 4, 1, 4 };

		System.out.println(new SubsetsII().subsetsWithDup(nums));
	}

	List<List<Integer>> subsetsWithDup(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> res = new ArrayList<>();

		subsetsWithDup(new LinkedList<>(), res, nums, 0);

		return res;
	}

	void subsetsWithDup(LinkedList<Integer> list, List<List<Integer>> res, int[] nums, int index) {

		res.add(new ArrayList<>(list));

		for (int i = index; i < nums.length; i++) {

			if (i > index && nums[i - 1] == nums[i])
				continue;

			list.add(nums[i]);
			subsetsWithDup(list, res, nums, i + 1);
			list.removeLast();
		}

	}

}
