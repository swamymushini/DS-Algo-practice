package com.trees.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeachSuggestions {

	public static void main(String[] args) {
		String[] inputs = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		new SeachSuggestions().suggestedProducts(inputs, "mouse");
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

	public List<String> startsWith(String word) {
		Node curr = root;

		for (int i = 0; i < word.length(); i++) {

			char a = word.charAt(i);

			if (!curr.map.containsKey(a)) {
				return new ArrayList<>();
			}

			curr = curr.map.get(a);
		}
		List<String> words = new ArrayList<>();

		getMatchedWords(words, curr, word);

		return words;
	}

	public void getMatchedWords(List<String> words, Node node, String prefix) {

		if (node.isEnd)
			words.add(prefix);

		for (Character c : node.map.keySet()) {
			getMatchedWords(words, node.map.get(c), prefix + c);
		}

	}

	public List<List<String>> suggestedProducts(String[] products, String word) {
		List<List<String>> res = new ArrayList<>();

		for (String product : products) {
			insert(product);
		}

		for (int i = 0; i < word.length(); i++) {
			String s2 = word.substring(0, i + 1);
			List<String> words = startsWith(s2).stream().sorted().limit(3).collect(Collectors.toList());
			res.add(words);
		}

		return res;
	}
}
