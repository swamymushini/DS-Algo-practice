package com.binarySearch;

public class FirstGreaterElement {

	public static void main(String[] args) {
		int findElement = new FirstGreaterElement().findElement(new int[] { 2, 5, 10, 15, 20, 25 }, 11);
		System.out.println(findElement);
	}

	int findElement(int[] potions, int target) {

		int l = 0;
		int r = potions.length - 1;

		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (potions[mid] >= target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		System.out.println(l);
		return r;
	}

}
