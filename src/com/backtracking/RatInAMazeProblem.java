package com.backtracking;

import java.util.ArrayList;

public class RatInAMazeProblem {

	public static void main(String[] args) {
		int[][] array = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		ArrayList<String> findPath = new RatInAMazeProblem().findPath(array);
		System.out.println(findPath);
	}

	public ArrayList<String> findPath(int[][] mat) {
		ArrayList<String> res = new ArrayList<>();

		findPath(mat, res, 0, 0, new StringBuilder());

		return res;
	}

	public void findPath(int[][] mat, ArrayList<String> res, int i, int j, StringBuilder sb) {
		if (i > 0 || j < 0 || i >= mat.length || j >= mat[0].length)
			return;

		if (mat[i][j] == 0 || mat[i][j] == 2)
			return;

		if (i == mat.length - 1 && j == mat[0].length - 1) {
			res.add(sb.toString());
			return;
		}

		mat[i][j] = 2;
		sb.append("D");
		findPath(mat, res, i + 1, j, sb);
		sb.deleteCharAt(sb.length() - 1);

		sb.append("R");
		findPath(mat, res, i, j + 1, sb);
		sb.deleteCharAt(sb.length() - 1);

		sb.append("L");
		findPath(mat, res, i, j - 1, sb);
		sb.deleteCharAt(sb.length() - 1);

		sb.append("U");
		findPath(mat, res, i - 1, j, sb);
		sb.deleteCharAt(sb.length() - 1);
		mat[i][j] = 1;
	}

}
