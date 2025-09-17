package com.dp;
import java.util.*;

public class Solution {
    // Adjacency list to represent the tree
    private static List<List<Integer>> adj;
    // Array to track the current value of each node
    private static int[] current;
    // Array of expected values
    private static int[] expected;
    // Counter for the number of flips
    private static int flips;

    public static int getMinimumOperations(int treeNodes, List<Integer> treeFrom, List<Integer> treeTo, List<Integer> initial, List<Integer> expected) {
        // Initialize adjacency list
        adj = new ArrayList<>();
        for (int i = 0; i <= treeNodes; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the undirected tree
        for (int i = 0; i < treeFrom.size(); i++) {
            int u = treeFrom.get(i);
            int v = treeTo.get(i);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Initialize arrays
        current = new int[treeNodes + 1];
        Solution.expected = new int[treeNodes + 1];
        for (int i = 0; i < treeNodes; i++) {
            current[i + 1] = initial.get(i);
            Solution.expected[i + 1] = expected.get(i);
        }

        // Reset flip counter
        flips = 0;

        // Start DFS from node 1 (root)
        dfs(1, -1, 0);

        return flips;
    }

    private static void dfs(int node, int parent, int flipCount) {
        // Calculate the current value of the node after considering flips from ancestors
        int nodeValue = current[node] ^ (flipCount % 2); // XOR with flipCount % 2 to determine if flipped

        // If the current value doesn't match the expected value, we need to flip
        if (nodeValue != expected[node]) {
            flips++; // Increment flip counter
            flipCount++; // Increment flip count for this subtree
        }

        // Visit all children
        for (int child : adj.get(node)) {
            if (child != parent) { // Avoid going back to the parent
                dfs(child, node, flipCount);
            }
        }
    }
}