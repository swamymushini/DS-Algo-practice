package com.trees.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2 {
	static TreeMap<Integer, String> wordWeightMap = new TreeMap<Integer, String>(Collections.reverseOrder());

	public static void main(String[] args) {

		extracted(new String[] { "abcd", "aecd", "abaa", "abef", "acdcc", "acbcc" }, new int[] { 2, 1, 3, 4, 6, 5 },
				new String[] { "ab", "abc", "a" }, new Node(' '));

	}

	private static void extracted(String[] dictionary, int[] weights, String[] prefixes, Node root) {
		for (int i = 0; i < dictionary.length; i++) {
			addToTrie(root, dictionary[i], weights[i]);
		}

		for (int i = 0; i < prefixes.length; i++) {
			getWordsWithPrefix(root, prefixes[i]).forEach(w -> System.out.print(w + " "));
			System.out.println("");
		}
	}

	private static void addToTrie(Node root, String word, int weight) {
		// insert a word in Trie
		Node temp = root;
		int l = word.length();
		for (int i = 0; i < l; i++) {
			int index = word.charAt(i) - 'a';
			if (temp.children[index] == null) {
				Node newNode = new Node(word.charAt(i));
				temp.children[index] = newNode;
			}
			temp = temp.children[index];
		}
		temp.weights.add(weight);
	}

	private static List<String> getWordsWithPrefix(Node root, String word) {
		List<String> ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		Node temp = root;
		int len = word.length();

		for (int i = 0; i < len; i++) {
			int index = word.charAt(i) - 'a';
			if (temp == null || temp.children[index] == null) {
				ans.add("-1");
				return ans;
			}

			if (i > 0)
				sb.append(temp.ch);

			temp = temp.children[index];
		}

		getAllWordsOfANode(temp, sb);

		int count = 5;

		Iterator<String> itr = wordWeightMap.values().iterator();
		while (itr.hasNext() && count-- > 0)
			ans.add((String) itr.next());
		wordWeightMap.clear();

		return ans;
	}

	private static void getAllWordsOfANode(Node root, StringBuilder sb) {
		if (root == null)
			return;

		sb.append(root.ch);

		if (!root.weights.isEmpty()) {
			String str = sb.toString();
			root.weights.forEach(w -> wordWeightMap.put(w, str));
		}

		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null)
				getAllWordsOfANode(root.children[i], new StringBuilder(sb.toString()));
		}
	}
}

class Node {

	char ch;
	Node[] children = new Node[26];
	List<Integer> weights = new ArrayList<>();

	Node(char c) {
		ch = c;
	}
}
