package com.arrays;

import java.util.Arrays;

public class LargestNumber {

	public static void main(String[] args) {
		System.out.println(new LargestNumber().largestNumber(new int[] { 8, 89 }));
	}

	public String largestNumber(final int[] A) {
		
		Integer[] newArray = new Integer[A.length];
		int j = 0;
		
		for (int value : A) {
		    newArray[j++] = Integer.valueOf(value);
		}

		
		StringBuilder sb = new StringBuilder();

		Arrays.sort(newArray, (a, b) -> {
				
			String s = a+""+b;
			String s2 = b+""+a;
			
			return s2.compareTo(s);
		});
		
		for (int i = 0; i < newArray.length; i++) {
			sb.append(newArray[i]);
		}
		return sb.toString();

	}

}
