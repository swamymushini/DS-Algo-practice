package com.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.util.Util;

public class TopKFrequentElements {

	private static int[] topKFrequent;

	public static void main(String[] args) {
		topKFrequent = new TopKFrequentElements().topKFrequent(new int[] { 1, 2 }, 2);
		Util.printArray(topKFrequent);
	}

	public int[] topKFrequent(int[] nums, int k) {
        List<Integer> subList = new ArrayList<>(10);
        subList.size();
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, HashSet<Integer>> freqMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			int value = map.getOrDefault(nums[i], 0);

			if (freqMap.get(value) != null) {
				HashSet<Integer> hashSet = freqMap.get(value);
				hashSet.remove(nums[i]);
			}

			value = value + 1;

			HashSet<Integer> set = freqMap.getOrDefault(value, new HashSet<>());
			set.add(nums[i]);
			freqMap.put(value, set);
			map.put(nums[i], value);
		}

		int[] res = new int[k];
		int i = 0;

		int size = nums.length;

		while (i < res.length) {

			HashSet<Integer> set = freqMap.get(size--);

			if (set == null || set.size() == 0) {
				continue;
			}

			for (Integer item : set) {

				if (i >= res.length) {
					return res;
				}
				res[i++] = item;
			}

		}

		return res;
	}
}
