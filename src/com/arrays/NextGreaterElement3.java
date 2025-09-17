package com.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NextGreaterElement3 {

	public static void main(String[] args) {
		System.out.println(new NextGreaterElement3().nextGreaterElement(230241));
	}

	public int nextGreaterElement(int n) {
		List<Integer> arr = new ArrayList<>();

		while (n > 0) {
			int val = n % 10;
			arr.add(val);
			n = n / 10;
		}

		int min = 0;
		int index = -1;

		for (int i = 1; i < arr.size(); i++) {

			if (arr.get(i) < arr.get(i - 1)) {
				index = i;
				break;
			}

		}

		if (index == -1)
			return -1;

		int minValue = Integer.MAX_VALUE;

		for (int i = 0; i < index; i++) {

			if (arr.get(i) > arr.get(index)) {

				if (arr.get(i) < minValue) {
					minValue = arr.get(i);
					min = i;
				}

			}
		}

		int swap = arr.get(min);
		arr.set(min, arr.get(index));
		arr.set(index, swap);

		Collections.sort(arr.subList(0, index), Collections.reverseOrder());
		Collections.reverse(arr);
		String result = arr.stream().map(String::valueOf).collect(Collectors.joining());
		Long res = Long.valueOf(result);

		if (res < Integer.MAX_VALUE)
			return Integer.valueOf(result);

		return -1;
	}

}
