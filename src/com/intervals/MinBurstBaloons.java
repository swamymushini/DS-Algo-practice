package com.intervals;

import java.util.Arrays;

public class MinBurstBaloons {
	public int findMinArrowShots(int[][] points) {

		Arrays.sort(points, (a, b) -> {
			if (a[0] == b[0])
				return Integer.compare(a[1], b[1]);
			else
				return Integer.compare(a[0], b[0]);
		});

		int a = points[0][0];
		int b = points[0][1];
		int count = 1;

		for (int i = 1; i < points.length; i++) {

			int a1 = points[i][0];
			int b1 = points[i][1];

			if (a1 <= b1) {
				a = a1;
				b = Math.min(b, b1);
			} else {
				count++;
			}

		}

		return count;
	}
}
