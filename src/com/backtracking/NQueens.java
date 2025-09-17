package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	
	public static void main(String[] args) {
		System.out.println(new NQueens().solveNQueens(4));
	}

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        solveNQueens(n, new boolean[n][n], 0, res);
        return res;
    }

    private void appendToResult(boolean[][] curr, List<List<String>> res) {

        List<String> arr = new ArrayList<>();
       
        
        for (int i = 0; i < curr.length; i++) {
            
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < curr.length; j++) {
                sb.append(curr[i][j] ? "Q" : ".");
            }

            arr.add(sb.toString());
        }

        res.add(arr);

    }

    private void solveNQueens(int n, boolean[][] curr, int row, List<List<String>> res) {

        if (n == row) {
            appendToResult(curr, res);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(curr, row, i, n)) {
                curr[row][i] = true;
                solveNQueens(n, curr, row + 1, res);
                curr[row][i] = false;
            }
        }

    }

    private boolean check(boolean[][] curr, int row, int col, int n) {

        int i = row;
        int j = col;
       
        while (--i >= 0) {
            if (curr[i][j]) {
                return false;
            }
        }

        i = row;
        j = col;

        while (--i >= 0 && ++j < n) {

            if (curr[i][j]) {
                return false;
            }

        }

        i = row;
        j = col;

        while (--i >= 0 && --j >= 0) {

            if (curr[i][j]) {
                return false;
            }

        }
        return true;

    }

}