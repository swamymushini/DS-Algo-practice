package com.minheap;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestInfiniteSet {

	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	HashSet<Integer> set = new HashSet<>();

	int count = 0;

	public SmallestInfiniteSet() {

	}

	public int popSmallest() {

		if (minHeap.isEmpty() || minHeap.peek() > count + 1) {
			count++;
			return count;
		} else if (minHeap.peek() < count + 1) {
			set.remove(minHeap.peek());
			return minHeap.poll();
		} else {
			set.remove(minHeap.peek());
			minHeap.poll();
			count++;
			return count;
		}

	}

	public void addBack(int num) {

		if (set.add(num))
			minHeap.add(num);

	}
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet(); int param_1 =
 * obj.popSmallest(); obj.addBack(num);
 */