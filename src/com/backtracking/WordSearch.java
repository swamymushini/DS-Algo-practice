package com.backtracking;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B' }, { 'C', 'D' } };

		String word = "CDBA";

		System.out.println(new WordSearch().exist(board, word));
	}

	public boolean exist(char[][] board, String word) {

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {

				if (exist(board, word, 0, i, j, new boolean[board.length][board[0].length])) {
					return true;
				}

			}

		}

		return false;
	}

	boolean exist(char[][] board, String word, int currIndex, int i, int j, boolean[][] tracker) {

		if (currIndex == word.length()) {
			return true;
		}

		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || tracker[i][j])
			return false;

		boolean matches = false;

		char c = board[i][j];

		if (c != word.charAt(currIndex)) {
			return false;
		}
		
		tracker[i][j] = true;

		matches = exist(board, word, currIndex + 1, i - 1, j, tracker)
				|| exist(board, word, currIndex + 1, i + 1, j, tracker)
				|| exist(board, word, currIndex + 1, i, j - 1, tracker)
				|| exist(board, word, currIndex + 1, i, j + 1, tracker);

		tracker[i][j] = false;

		return matches;

	}

}