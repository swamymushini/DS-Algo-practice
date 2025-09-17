package com.arrays;

import java.util.HashSet;

class ValidSudoku {

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		boolean validSudoku = new ValidSudoku().isValidSudoku(board);
		System.out.println(validSudoku);
	}

	public boolean isValidSudoku(char[][] board) {
		HashSet<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		sb.deleteCharAt(0);
		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {

				if (board[i][j] == '.')
					continue;

				int val = board[i][j] - 48;

				String row = i + " R" + val;
				String col = j + " C" + val;
				String box = (i - i % 3) + "-" + (j - j % 3) + " B" + val;
				System.out.println(row);
				System.out.println(col);
				System.out.println(box);
				if (!set.add(row) || !set.add(col) || !set.add(box))
					return false;

			}

		}

		return true;
	}
}