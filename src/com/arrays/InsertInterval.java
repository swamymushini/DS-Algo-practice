package com.arrays;

import java.util.ArrayList;

import com.util.Util;

public class InsertInterval {

	public static void main(String[] args) {
		new InsertInterval().insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } },
				new int[] { 4, 8 });
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {

		ArrayList<int[]> arr = new ArrayList<int[]>();

		for (int[] in : intervals) {

			if (in[1] < newInterval[0]) {
				arr.add(in);
			} else if (newInterval[1] < in[0]) {
				arr.add(newInterval);
				newInterval = in;
			} else {
				newInterval[0] = Math.min(newInterval[0], in[0]);
				newInterval[1] = Math.min(newInterval[1], in[1]);
			}

		}

		arr.add(newInterval);

		return Util.listtoArray(arr);
	}

	

}