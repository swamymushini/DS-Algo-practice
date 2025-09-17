package com.queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.util.Util;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		System.out.println(new SlidingWindowMaximum()
				.slidingMaximum(Util.createArrayList(new int[] { -2, -1 ,3, 0, 2, 1, 4 }), 3));
	}

	public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();

		dq.add(A.get(0));

		for (int i = 1; i < B; i++) {

			int val = A.get(i);

			while (!dq.isEmpty() && dq.getLast() < val)
				dq.removeLast();

			dq.addLast(val);

		}

		result.add(dq.getFirst());

		for (int i = B; i < A.size(); i++) {

			int prev = A.get(i - B);
			int val = A.get(i);

			if (prev == dq.getFirst())
				dq.removeFirst();

			while (!dq.isEmpty() && dq.getLast() < val)
				dq.removeLast();

			dq.addLast(val);

			result.add(dq.getFirst());
		}

		return result;
	}
}
