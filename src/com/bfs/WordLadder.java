package com.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {

		System.out.println(
				new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		HashMap<String, Integer> map = new HashMap<>();

		HashMap<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < wordList.size(); i++) {
			map.put(wordList.get(i), i);
		}

		if (!map.containsKey(endWord)) {
			return 0;
		}

		
		findEdges(graph, -1, map, beginWord);

		for (int i = 0; i < wordList.size(); i++) {
			findEdges(graph, i, map, wordList.get(i));
		}

		Set<Integer> set = new HashSet<>();

		Queue<Integer> qu = new LinkedList<>();

		qu.add(-1);
		qu.add(null);
		set.add(-1);

		int count = 1;

		while (!qu.isEmpty()) {

			Integer poll = qu.poll();

			if (poll == null) {

				count++;

				if (qu.isEmpty())
					break;

				qu.add(null);
				continue;
			}

			if (poll == map.get(endWord))
				return count;

			if (!graph.containsKey(poll))
				continue;

			List<Integer> list = graph.get(poll);

			for (int indx : list) {

				if (set.add(indx))
					qu.add(indx);

			}

		}

		return 0;
	}

	void findEdges(HashMap<Integer, List<Integer>> graph, int index, HashMap<String, Integer> map, String word) {

		char[] charArray = word.toCharArray();

		for (int i = 0; i < word.length(); i++) {

			char old = word.charAt(i);

			for (char c = 'a'; c <= 'z'; c++) {

				charArray[i] = c;

				String newWord = new String(charArray);

				if (map.containsKey(newWord) && !newWord.equals(word))
					graph.compute(index, (k, v) -> v != null ? v : new ArrayList<Integer>()).add(map.get(newWord));

				charArray[i] = old;
			}

		}

	}
}
