package com.backtracking;

class SolveSudoku {

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		new SolveSudoku().solveSudoku(board);
		printBoard(board);
	}

	static char[][] res = new char[9][9];

	public void solveSudoku(char[][] board) {
		isValidSudoku(board, 0);
		board = cloneArray(res, board);
	}

	public void isValidSudoku(char[][] board, int n) {

		if (n == 81) {
			res = board;
			return;
		}

		int i = n / 9;
		int j = n % 9;

		if (board[i][j] != '.') {
			isValidSudoku(board, n + 1);
		} else {

			for (char k = 49; k < 58; k++) {
				if (check(board, i, j, k)) {
					board[i][j] = k;
					isValidSudoku(board, n + 1);
					board[i][j] = '.';
				}

			}
		}

	}

	public static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static char[][] cloneArray(char[][] res, char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				res[i][j] = board[i][j];
			}
		}
		return res;
	}

	boolean check(char[][] board, int i, int j, char k) {
		int l = 0;
		while (l < 9) {
			if (board[l++][j] == k) {
				return false;
			}
		}

		l = 0;
		while (l < 9) {
			if (board[i][l++] == k) {
				return false;
			}
		}

		i = i - i % 3;
		j = j - j % 3;

		l = i;

		while (l < i + 3) {

			int m = j;

			while (m < j + 3) {

				if (board[l][m] == k)
					return false;

				m++;
			}

			l++;

		}

		return true;
	}

}