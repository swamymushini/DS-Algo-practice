package com.bfs;

import java.util.*;

import com.bfs.CheapestFlightsWithinKStops.Edge;

class Solution {

	static class Edge {
		int dest;
		int price;

		public Edge(int dest, int price) {
			this.dest = dest;
			this.price = price;
		}
	}

	static class Trip {
		int src;
		int totalPrice;
		int stops;

		public Trip(int stops, int src, int totalPrice) {
			this.src = src;
			this.totalPrice = totalPrice;
			this.stops = stops;
		}

	}

	public int findCheapestPrice(int n, int flights[][], int src, int dst, int K) {

		ArrayList<ArrayList<Edge>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        int m = flights.length; 
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Edge(flights[i][1], flights[i][2])); 
        }
        

		Queue<Trip> q = new LinkedList<>();

		q.add(new Trip(0, src, 0));

		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = (int) (1e9);
		}
		dist[src] = 0;

		while (!q.isEmpty()) {
			Trip it = q.peek();
			q.remove();

			int stops = it.stops;
			int node = it.src;
			int cost = it.totalPrice;

			if (stops > K)
				continue;
			for (Edge iter : adj.get(node)) {
				int adjNode = iter.dest;
				int edW = iter.price;

				if (cost + edW < dist[adjNode] && stops <= K) {
					dist[adjNode] = cost + edW;
					q.add(new Trip(stops + 1, adjNode, cost + edW));
				}
			}
		}
		if (dist[dst] == (int) (1e9))
			return -1;
		return dist[dst];
	}
}
