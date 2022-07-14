package com.hashing;

import java.util.HashSet;
import java.util.Set;

public class CountRectangles {

	public static void main(String[] args) {
		System.out.println(new CountRectangles().solve(new int[] { 1, 1, 2, 2 }, new int[] { 1, 2, 1, 2 }));
	}

	public int solve(int[] A, int[] B) {

		int cnt = 0;

		Set<Points> set = new HashSet<>();

		for (int i = 0; i < B.length; i++) {
			set.add(new Points(A[i], B[i]));
		}

		for (int i = 0; i < A.length; i++) {

			int x1 = A[i];
			int y1 = B[i];

			for (int j = i + 1; j < B.length; j++) {

				int x4 = A[j];
				int y4 = B[j];

				if (x1 != x4 && y1 != y4 && set.contains(new Points(x4, y1)) && set.contains(new Points(x1, y4))) {
					cnt++;
				}

			}

		}

		return cnt / 2;
	}

	class Points {

		int x;
		int y;

		public Points(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			Points point = (Points) obj;
			return point.x == x && point.y == y;
		}

		@Override
		public int hashCode() {
			return this.x * (this.y / (this.x + 1)) * 2 + this.y + (this.x / (this.y + 1)) * 4;
		}

	}

}
