package com.queues;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate_649 {

	public static void main(String[] args) {
		new Dota2Senate_649().predictPartyVictory("RRD");
	}

	Queue<Character> qu = new LinkedList<>();

	public String predictPartyVictory(String senate) {

		for (int i = 0; i < senate.length(); i++) {
			Character c = senate.charAt(i);
			qu.add(c);
		}

		while (!qu.isEmpty()) {

			Character c = qu.poll();

			if (qu.isEmpty()) {
				return c == 'R' ? "Radiant" : "Dire";
			}

			qu.add(c);

			if (c == qu.peek()) {
				continue;
			}

			qu.poll();

		}

		return "Radiant";
	}
}