package com.arrays;

import java.util.ArrayList;

public class MaximumSumSubMatrix {

	public static void main(String[] args) {

		int[][] k = new int[][] {
//				{ -95, -47, 71, 80, 40, 30, -25, 20, 90, 77, 98, 86, -96, -11, -69, 44, 88, -90, 18, 19, -41, 27 },
//				{ -91, 19, -21, 16, 0, 96, -47, -42, -70, 93, -94, -51, -46, -28, 60, -6, -46, 33, 46, -71, -29, -72 },
//				{ 59, -59, -79, -12, 66, -67, -15, -30, 29, -39, -40, -92, 82, 62, 6, -22, 79, -3, -13, 38, -31, 83 },
//				{ 40, 95, -34, -67, 9, 57, 17, 34, -47, 35, -42, 93, -57, -7, -34, 51, 40, -6, 37, 74, 12, -3 },
//				{ 51, -5, -83, -8, -8, -63, 30, -87, -4, 10, 89, -72, -91, 86, 44, -60, 82, 69, 20, 93, -8, 62 },
//				{ -86, 27, -93, 94, 5, 13, -89, 13, -7, -36, -97, 95, 62, 81, 46, 9, -52, 68, -76, 11, 54, -65 },
//				{ 27, -67, -60, -38, 27, 77, -83, 40, 42, 0, -100, 58, -24, 54, 35, -70, -69, -5, 37, -77, 22, 27 },
//				{ -71, -89, -89, 54, -20, -47, -7, 21, 85, 28, -57, -100, 55, -29, -30, -48, 75, -69, -60, 34, -60,
//						86 },
//				{ -66, -52, 39, 65, 96, 12, -38, -48, 31, 87, -36, 57, -52, 56, 70, -50, 82, 1, -7, -1, 32, -56 },
//				{ 31, -25, -96, -50, -74, -34, 38, -99, -77, -57, -59, 80, -5, 18, -41, 63, -72, 29, -12, -46, -87,
//						79 },
//				{ 69, -34, -21, 77, -63, -98, 15, -8, 23, -28, -52, 23, 53, 48, 95, 97, 8, 8, -89, 93, -35, 81 },
//				{ -98, -90, -72, -44, 5, 65, -77, 69, 15, -47, -95, -16, -22, 45, -60, -67, -15, 0, 68, 94, -67, -15 },
//				{ 48, -19, -68, -44, 10, -28, 82, 1, 6, -65, -40, -29, 27, 37, 43, 68, -67, 95, 71, -97, 42, -89 },
//				{ -21, -66, 12, 93, 30, 61, -66, -42, 26, 6, 91, -57, 88, -73, 19, -16, -76, -7, -65, -76, -6, 82 },
//				{ -33, -73, -95, 46, -14, 89, 40, -63, -50, 59, 78, 56, -23, -97, -58, 0, -89, -75, 43, 95, -84, -85 },
//				{ -96, -94, 68, -59, 35, -2, 25, 13, -77, 12, -82, -43, 96, 39, -14, -6, -54, -57, 22, 11, -20, -45 },
//				{ 58, -53, -30, 90, -27, 27, -87, -46, -4, -28, -50, -59, -59, -54, 25, -87, -76, 29, -5, -97, 94, 93 },
//				{ -33, 87, -60, -21, -59, 25, 34, -40, -100, 7, -79, -8, -7, 17, 17, -97, 43, -7, -61, -89, 25, -72 },
//				{ 78, 48, -50, -8, -56, -46, -77, 53, -64, 47, 46, -74, -39, 4, -62, 71, -14, -95, -1, -44, 28, -33 },
//				{ 51, -81, 91, 66, 17, -54, -7, 87, -79, 12, -33, -1, -56, -3, -99, 28, 42, 4, 68, 68, -59, -4 },
//				{ -38, 20, -56, 18, -75, -81, 84, 74, 84, -41, 49, -86, -5, 3, -68, -49, 37, -86, 63, -49, -81, -10 },
//				{ 17, -17, 18, 84, -48, 86, -31, -52, 37, 97, -76, 68, -73, 48, 93, 82, -29, -31, -7, -23, -86, 4 }
				{ 1, 1, 1, 1, 1 },
				{ 2, 2, 2, 2, 2 },
				{ 3, 8, 6, 7, 3 },
				{ 4, 4, 4, 4, 4 },
				{ 5, 5, 5, 5, 5 }
//				{2, 2},
//				{2, 2}

		};

		System.out.println(new MaximumSumSubMatrix().solve(MaximumSumSubMatrix.listtoArray(k), 3));
	}

	public int solve(ArrayList<ArrayList<Integer>> A, int B) {

		int max = Integer.MIN_VALUE;

		for (int st = 0; st < A.size() - B + 1; st++) {

			int[] a = new int[A.get(0).size()];

			for (int i = st; i < st + B; i++) {

				ArrayList<Integer> arr2 = A.get(i);
				for (int j = 0; j < A.get(0).size(); j++) {

					a[j] = a[j] + arr2.get(j);

				}

			}

			int ans = slidingWindow(a, B);

			max = Math.max(ans, max);

		}

		return max;
	}

	public static ArrayList<ArrayList<Integer>> listtoArray(int[][] arr) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < arr.length; i++) {

			int[] js = arr[i];

			ArrayList<Integer> temp = new ArrayList<Integer>();

			for (int j = 0; j < js.length; j++) {
				temp.add(js[j]);
			}

			res.add(temp);

		}

		return res;
	}

	private int slidingWindow(int[] a, int B) {

		int sum = 0;

		for (int i = 0; i < B; i++) {
			sum += a[i];
		}

		int max = sum;

		for (int i = B; i < a.length; i++) {

			sum += a[i] - a[i - B];
			max = Math.max(max, sum);

		}

		return max;
	}

}
