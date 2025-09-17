package com.trees.trie;

import java.util.HashMap;
import java.util.Map;

public class ModifiedSearch {

	public static void main(String[] args) {
		String solve = new ModifiedSearch().solve(new String[] { "data", "circle", "cricket" },
				new String[] { "date", "circel", "crikket", "data", "circl" });
		System.out.println(solve);
	}

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

	public class Trie {

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

	}

	public int find(String val, Node curr) {

		int cnt = 0;

		for (int i = 0; i < val.length(); i++) {
			char c = val.charAt(i);

			Map<Character, Node> hm = curr.getHm();

			if (hm.get(c) != null) {
				
				Node node = hm.get(c);
				
				for (Node c1 : hm.values()) {
					find(val, c1);
				}

			} else
				curr = hm.get(c);

		}

		return 0;
	}

	public String solve(String[] A, String[] B) {
		Trie t = new Trie();

		for (String s : A) {
			t.add(s);
		}

		String s = "";

		for (String s1 : B) {
			s += find(s1, t.root);
		}

		return s;
	}
}
