package com.graphs;

import java.util.ArrayList;
import java.util.List;

class Edge {
	int vertex;
	int weight;

	public Edge(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "(" + vertex + ", " + weight + ")";
	}
}

public class WeightedGraphExample {
	public static void main(String[] args) {
		int[] u = new int[] { 1, 1, 2, 2, 3, 5, 4 };
		int[] v = new int[] { 2, 4, 4, 3, 5, 6, 5 };
		int[] w = new int[] { 10, 20, 30, 40, 50, 60, 70 }; // Weights of the edges

		int numberOfVertices = 6;

		List<Edge>[] adjacencyList = new ArrayList[numberOfVertices + 1];

		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new ArrayList<>();
		}

		for (int i = 0; i < u.length; i++) {
			int a = u[i];
			int b = v[i];
			int weight = w[i];
			adjacencyList[a].add(new Edge(b, weight));
			adjacencyList[b].add(new Edge(a, weight)); // Since the graph is undirected
		}

		printGraph(adjacencyList);
	}

	public static void printGraph(List<Edge>[] adjacencyList) {
		for (int i = 1; i < adjacencyList.length; i++) { // Start from 1 to ignore 0th index
			System.out.print("Vertex " + i + ": ");
			for (Edge edge : adjacencyList[i]) {
				System.out.print(edge + " ");
			}
			System.out.println();
		}
	}
}
