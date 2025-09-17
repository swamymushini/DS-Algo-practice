package com.binarySearch;

public class TwoDsearch {

	public static void main(String[] args) {

		int res = new TwoDsearch().solve(new int[][] { { 2, 8, 8, 8 }, { 2, 8, 8, 8 }, { 2, 8, 8, 8 } }, 8);
		System.out.println(res);
	}

	public int solve(int[][] A, int target) {
		int rows = A.length;
		int cols = A[0].length;

		// Start from the top-right corner
		int row = 0;
		int col = cols - 1;
		int result = -1;

		while (row < rows && col >= 0) {
			if (A[row][col] == target) {
				result = returnCheck(row, col); // Update result to current position
				col--; // Continue searching to the left for an earlier occurrence
			} else if (A[row][col] > target) {
				col--; // Move left
			} else {
				row++; // Move down
			}
		}

		return result;
	}

	int returnCheck(int i, int j) {
		return (i + 1) * 1009 + (j + 1);
	}
}
