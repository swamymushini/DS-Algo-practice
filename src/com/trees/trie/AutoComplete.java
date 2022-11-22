package com.trees.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class AutoComplete {

	static class Node {

		Map<Character, Node> hm = new HashMap<>();
		public List<Integer> weights = new ArrayList<>();

		public Node() {
		}

		public Map<Character, Node> getHm() {
			return hm;
		}

	}

	static class Trie {

		Node root = new Node();

		void add(String s, int weight) {
			Node curr = root;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				Map<Character, Node> hm = curr.getHm();
				Node node = hm.getOrDefault(c, new Node());
				hm.put(c, node);
				curr = node;
			}
			curr.weights.add(weight);
		}
	}

	public static void main(String[] args) {
		solve(new String[] { "abcd", "aecd", "abaa", "abaa", "acdcc", "acbcc" }, new int[] { 2, 1, 3, 4, 6, 5 },
				new String[] { "ab", "abc", "a" });
	}

	public static void solve(String[] A, int[] W, String[] B) {

		Trie t = new Trie();

		for (int i = 0; i < A.length; i++) {
			t.add(A[i], W[i]);
		}

		Node root = t.root;

		for (String s : B) {

			Map<Integer, String> find = find(s, root);

			if (find.isEmpty()) {
				System.out.println("-1");
				continue;
			}
			int i = 5;

			for (String s1 : find.values()) {

				if (i-- <= 0)
					break;

				System.out.print(s1 + " ");
			}
			System.out.println();
		}
	}

	static Map<Integer, String> find(String pref, Node root) {

		Map<Integer, String> tmap = new TreeMap<>(Collections.reverseOrder());

		Node curr = root;

		for (int i = 0; i < pref.length(); i++) {
			char c = pref.charAt(i);
			Map<Character, Node> hm = curr.getHm();
			Node node = hm.get(c);
			if (node == null)
				return tmap;
			curr = node;
		}

		for (int weight : curr.weights)
			tmap.put(weight, pref);

		List<Pair> words = printWords(curr);

		for (Pair pair : words) {
			StringBuilder sb = new StringBuilder(pref).append(pair.word);
			tmap.put(pair.wt, sb.toString());
		}

		return tmap;
	}

	static class Pair {
		public Integer wt;
		public String word;

		public Pair(Integer wt, String word) {
			super();
			this.wt = wt;
			this.word = word;
		}

	}

	static List<Pair> printWords(Node node) {

		List<Pair> pairList = new LinkedList<>();

		Map<Character, Node> hm = node.getHm();

		for (Character c : hm.keySet()) {
			Node node2 = hm.get(c);
			List<Pair> words = printWords(node2);

			for (int weight : node2.weights)
				pairList.add(new Pair(weight, c.toString()));

			for (Pair pair : words) {
				StringBuilder sb = new StringBuilder(c.toString()).append(pair.word);
				pairList.add(new Pair(pair.wt, sb.toString()));
			}
		}

		return pairList;
	}

}
