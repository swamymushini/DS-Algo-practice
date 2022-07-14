package com.bitManipulations;

public class AddBinaryStrings {
	public String addBinary(String A, String B) {

		int a = A.length();
		int b = B.length();

		int i = a - 1;
		int j = b - 1;
		int car = 0;
		
		

		StringBuilder sb = new StringBuilder();

		
		while (i >= 0 || j >= 0) {

			int l = (i < 0) ? 0 : Character.getNumericValue(A.charAt(i));
			int m = (j < 0) ? 0 : Character.getNumericValue(B.charAt(j));

			int sum = l + m + car;

			sb.append(sum % 2);

			car = sum / 2;
			i--;
			j--;
		}

		sb.append(car > 0 ? car : "");

		return sb.reverse().toString();
	}
}
