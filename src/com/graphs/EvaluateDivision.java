package com.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.util.Util;

public class EvaluateDivision {

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();
		equations.add(Arrays.asList("a", "b"));

		double[] values = { 0.5 };

		List<List<String>> queries = new ArrayList<>();
		queries.add(Arrays.asList("a", "b"));
		queries.add(Arrays.asList("b", "a"));
		queries.add(Arrays.asList("a", "c"));
		queries.add(Arrays.asList("x", "y"));

		double[] calcEquation = calcEquation(equations, values, queries);

		Util.printArray(calcEquation);

	}

	static class Node {
		double val;
		String b;

		public Node(String b, double val) {
			this.b = b;
			this.val = val;
		}
	}

	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		double[] result = new double[queries.size()];

		Map<String, ArrayList<Node>> map = new HashMap<>();

		int i = 0;
		for (List<String> list : equations) {
			String a = list.get(0);
			String b = list.get(1);
			double val = values[i++];
			map.computeIfAbsent(a, k -> new ArrayList<>()).add(new Node(b, val));
			map.computeIfAbsent(b, k -> new ArrayList<>()).add(new Node(a, 1.0 / val));
		}
		i = 0;
		for (List<String> list : queries) {

			String a = list.get(0);
			String b = list.get(1);
			double count = 0.0;

			if (!map.containsKey(a) || !map.containsKey(b)) {
				count = -1.0;
			} else {
				count = getCount(map, a, b, new HashSet<>(), new Node(a, 1.0));
				count = count == 0.0 ? -1.0 : count;
			}

			result[i++] = count;
		}

		return result;
	}

	static double getCount(Map<String, ArrayList<Node>> map, String src, String dst, Set<String> set, Node curr) {

		if (curr.b.equals(dst)) {
			return !set.add(dst) ? 0.0 : curr.val;
		}

		if (set.contains(curr.b)) {
			set.add(curr.b);
			return 1.0;
		}

		set.add(curr.b);

		ArrayList<Node> arrayList = map.get(curr.b);
		double res = 0;

		for (Node node : arrayList) {

			if (!set.contains(node.b))
				res = Math.max(curr.val * getCount(map, src, dst, set, node), res);

		}

		return res;

	}

}
