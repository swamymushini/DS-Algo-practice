package com.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Trie {

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

	void printWords() {
		List<String> characters = getCharacters(root);
		System.out.println(characters);
	}

	List<String> getWords() {
		return getCharacters(root);
	}

	List<String> getCharacters(Node root) {

		List<String> res = new ArrayList<>();
		Node curr = root;
		Map<Character, Node> hm = curr.getHm();
		Set<Character> keySet = hm.keySet();

		for (Character c : keySet) {
			Node node = hm.get(c);
			List<String> chars = getCharacters(node);
			if (node.isEnd) {
				res.add(c.toString());
			}
			for (String word : chars) {
				StringBuilder sb = new StringBuilder(c.toString());
				sb.append(word);
				res.add(sb.toString());
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Trie t = new Trie();
		t.add("gopal");
		t.add("gopal1");
		t.add("gop");
		t.add("hello");
		t.add("hello1");
		t.printWords();
	}

}
