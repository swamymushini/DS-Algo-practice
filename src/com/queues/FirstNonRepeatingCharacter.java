package com.queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		System.out.println(new FirstNonRepeatingCharacter().solve("xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr"));
	}

	public String solve(String A) {

		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> map = new HashMap<>();

		Queue<Character> qu = new LinkedList<>();

		for (int i = 0; i < A.length(); i++) {

			char ch = A.charAt(i);

			if (map.get(ch) != null) {
				map.put(ch, 2);
			} else {
				qu.add(ch);
				map.put(ch, 1);
			}

			while (map.containsKey(qu.peek()) && map.get(qu.peek()) > 1) {
				qu.poll();
			}

			if (qu.isEmpty()) {
				sb.append('#');
			} else {
				sb.append(qu.peek());
			}

		}
		return sb.toString();

	}
}
