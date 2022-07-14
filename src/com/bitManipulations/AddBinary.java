package com.bitManipulations;

public class AddBinary {

	public static void main(String[] args) {
		System.out.println(new AddBinary().addBinary("1010110111001101101000", "1000011011000000111100110"));
	}

	public String addBinary(String A, String B) {

		String res = "";

		int diff = Math.abs(A.length() - B.length());

		if (A.length() < B.length()) {
			res = A;
			A = B;
			B = res;
		}
		res = "";

		int car = 0;
		int sum = 0;

		int rest = 0;

		for (int i = A.length() - 1; i >= 0; i--) {

			int num1 = returnNum(A.charAt(i));

			int num2 = 0;

			if (i >= diff)
				num2 = returnNum(B.charAt(i - diff));

			sum = num1 + num2 + car;

			rest = sum % 2;

			res = rest + res;

			car = (sum - rest) / 2;

		}

		if (car > 0) {
			res = car + res;
		}

		return res;
	}

	int returnNum(char c) {

		if (c == '1') {
			return 1;
		}

		return 0;
	}
}
