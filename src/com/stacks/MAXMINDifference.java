package com.stacks;

import com.util.Util;

public class MAXMINDifference {

	public static void main(String[] args) {

		int[] A = new int[] { 5, 2, 1, 3, 6, 8, 1, 1, 8 };

		Util.printArray(new NearestSmallestLeft().nearestSmallLeft(A));
		Util.printArray(new NearestSmallestRight().nearestSmallRight(A));
		Util.printArray(new NearestLargestLeft().nearestLargeLeft(A));
		Util.printArray(new NearestLargestRight().nearestLargeRight(A));

	}

}
