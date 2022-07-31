package com.queues;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {

	public static void main(String[] args) {
		System.out.println(new PerfectNumbers().solve(8));
	}

	public String solve(int A) {

		Queue<String> qu = new LinkedList<String>();
		qu.add("1");
		qu.add("2");

		while (A > 1) {
			String x = qu.poll();
			qu.add(x + "1");
			qu.add(x + "2");
			A--;
		}
		
		String poll = qu.poll();
		
		StringBuilder sb = new StringBuilder(poll);
		sb.reverse();
		return poll + sb.toString();
	}
}
