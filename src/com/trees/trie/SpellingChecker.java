package com.trees.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpellingChecker {

	public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
		Trie t = new Trie();

		ArrayList<Integer> res = new ArrayList<Integer>();

		for (String s : A) {
			t.add(s);
		}

		for (String s : B) {
			if (t.find(s)) {
				res.add(1);
			} else {
				res.add(0);
			}
		}

		return res;
	}

	class Trie {

		class Node {

			Map<Character, Node> hm = new HashMap<>();
			public boolean isEnd = false;

			public Node() {
			}

			public Map<Character, Node> getHm() {
				return hm;
			}

			public void setEnd(boolean isEnd) {
				this.isEnd = isEnd;
			}

		}

		Node root = new Node();

		void add(String s) {
			Node curr = root;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				Map<Character, Node> hm = curr.getHm();
				Node node = hm.getOrDefault(c, new Node());
				hm.put(c, node);
				curr = node;
			}
			curr.isEnd = true;
		}

		boolean find(String s) {
			Node curr = root;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				Map<Character, Node> hm = curr.getHm();
				Node node = hm.get(c);
				if (node == null)
					return false;
				curr = node;
			}
			return curr.isEnd;
		}

	}
}
