package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

	public static void main(String[] args) {
		System.out.println(
				new MergeIntervals().merge(new int[][] { { 1, 3 }, { 2, 6 } }));
	}

	public int[][] 
			merge(int[][] intervals) {

		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();

		Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

		for (int i = 0; i < intervals.length; i++) {
			int a = intervals[i][0];
			int b = intervals[i][1];

			int aa = a;
			int bb = b;
			ArrayList<Integer> sub = new ArrayList<>();

			for (int j = i + 1; j < intervals.length; j++) {

				int c = intervals[j][0];
				int d = intervals[j][1];

				if (b >= c) {

					if (b <= d) {
						b = d;
						bb = d;
					}

					i++;
				} else {
					break;
				}
			}

			sub.add(aa);
			sub.add(bb);
			arr.add(sub);

		}

		return  listtoArray(arr);
	}

	private int[][] listtoArray(ArrayList<ArrayList<Integer>> arr) {

		int[][] arr1 = new int[arr.size()][2];

		for (int j = 0; j < arr.size(); j++) {
			ArrayList<Integer> arrayList = arr.get(j);
			for (int i = 0; i < arrayList.size(); i++) {
				arr1[j][i] = arrayList.get(i);
			}

		}

		return arr1;
	}
}