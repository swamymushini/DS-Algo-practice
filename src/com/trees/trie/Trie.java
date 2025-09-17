package com.trees.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	public static void main(String[] args) {

	}

	class Node {
		boolean isEnd;
		Map<Character, Node> map = new HashMap<>();

	}

	Node root = new Node();

	public void insert(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char a = word.charAt(i);
			if (curr.map.containsKey(a)) {
				curr = curr.map.get(a);
				continue;
			}
			Node newNode = new Node();
			curr.map.put(a, newNode);
			curr = newNode;
		}
		curr.isEnd = true;
	}

	public boolean search(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char a = word.charAt(i);
			if (!curr.map.containsKey(a)) {
				return false;
			}
			curr = curr.map.get(a);
		}

		return curr.isEnd;
	}

	public boolean startsWith(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char a = word.charAt(i);
			if (!curr.map.containsKey(a)) {
				return false;
			}
			curr = curr.map.get(a);
		}

		return true;
	}

}
