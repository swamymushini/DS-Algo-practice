package com.trees.trie;

import java.util.HashMap;
import java.util.Map;

import com.util.Util;

public class ShortestUniQPref {

	public static void main(String[] args) {
		String[] prefix = new ShortestUniQPref()
				.prefix(new String[] { "bearcate", "bearcat", "bert", "zebra", "dog", "duck", "dove" });
		Util.printArray(prefix);
	}

	class Trie {

		class Node {

			Map<Character, Node> hm = new HashMap<>();
			public boolean isEnd = false;

			public Node() {
			}

			int freq = 0;

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
				node.freq = node.freq + 1;
				hm.put(c, node);
				curr = node;
			}
			curr.isEnd = true;
		}

	}

	String find(String s, Trie.Node root) {

		StringBuilder sb = new StringBuilder();

		Map<Character, Trie.Node> hm = root.getHm();
		Character c = s.charAt(0);
		sb.append(c.toString());

		Trie.Node curr = hm.get(s.charAt(0));

		for (int i = 1; i < s.length(); i++) {

			Map<Character, Trie.Node> hm2 = curr.getHm();

			if (curr.freq == 1) {
				return sb.toString();
			}

			c = s.charAt(i);
			sb.append(c.toString());

			Trie.Node node = hm2.get(c);
			curr = node;
		}

		return sb.toString();
	}

	public String[] prefix(String[] A) {

		Trie t = new Trie();
		String[] res = new String[A.length];

		for (int i = 0; i < A.length; i++) {
			t.add(A[i]);
		}

		for (int i = 0; i < A.length; i++) {
			res[i] = find(A[i], t.root);
		}

		return res;
	}

}
