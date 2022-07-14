package com.patterns;

public class Diagonal {
	public static void main(String[] args) {

//		Scanner myObj = new Scanner(System.in);

//		String numb = myObj.nextLine();

		int num = Integer.valueOf(6);

		for (int i = 0; i < num * 2; i++) {

			for (int j = 0; j < num * 2; j++) {

				int x = i;

				if (i >= num) {
					x = num - i % num - 1;
				}

				if (j >= num - x && j < num + x) {
					System.out.print(" ");
				} else
					System.out.print("*");

			}

			System.out.println();

		}

	}
}