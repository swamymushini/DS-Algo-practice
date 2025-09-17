package com.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

	private static List<List<Integer>> combinationSum;

	public static void main(String[] args) {
		int[] ip = {2,3,6,7 };

		combinationSum = new CombinationSum().combinationSum(ip, 7);

		System.out.println(combinationSum);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> res = new ArrayList<>();

		combinationSum(candidates, target, 0, res, new LinkedList<Integer>(), 0);

		return res;

	}

	void combinationSum(int[] candidates, int target, int currSum, List<List<Integer>> res,
			LinkedList<Integer> currList, int k) {

		if (currSum > target)
			return;

		if (currSum == target) {
			ArrayList<Integer> sub = new ArrayList<>(currList);
			res.add(sub);
			return;
		}

		for (int i = k; i < candidates.length; i++) {

			int val = candidates[i];

			currList.add(val);

			combinationSum(candidates, target, currSum + val, res, currList, i);
			currList.removeLast();
		}

	}

}
