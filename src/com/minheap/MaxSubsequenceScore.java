package com.minheap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSubsequenceScore {

	class Pair {

		int a;
		int b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

	}

	public long maxScore(int[] nums1, int[] nums2, int k) {

		List<Pair> pairs = new ArrayList<>();

		for (int i = 0; i < nums1.length; i++) {
			pairs.add(new Pair(nums1[i], nums2[i]));
		}

		pairs.sort(Comparator.comparing((Pair p) -> p.b).reversed());

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		long sum = 0;
		long res = 0;

		for (int i = 0; i < pairs.size(); i++) {

			Pair pair = pairs.get(i);
			minHeap.add(pair.a);
			sum = sum + pair.a;

			if (minHeap.size() >= k) {
				res = Math.max(sum * pair.b, res);
				Integer poll = minHeap.poll();
				sum = sum - poll;
			}

		}

		return res;

	}

}
