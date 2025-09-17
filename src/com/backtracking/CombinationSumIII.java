package com.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		combinationSum3(k, n, new LinkedList<>(), res, 0, 1);
		return res;
	}

	void combinationSum3(int k, int n, LinkedList<Integer> curr, List<List<Integer>> res, int currSum, int num) {

		if (curr.size() == k) {
			if (currSum == n) {
				res.add(new ArrayList(curr));
			}
			return;
		}

		for (int i = num; i <= 9; i++) {
			curr.add(i);
			combinationSum3(k, n, curr, res, currSum + i, i + 1);
			curr.removeLast();
		}
	}
}
