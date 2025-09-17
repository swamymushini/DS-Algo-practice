package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class PrintNumbersUptoN {

	static int k = 5;

	public static void main(String[] args) {
		printNumbersUptoN(new LinkedList<Integer>(), 3, 1);
	}

	static void printNumbersUptoN(LinkedList<Integer> arr, int n, int num) {

		System.out.println(new ArrayList<Integer>(arr));

		if (num > n) {
			return;
		}

		for (int i = num; i <= n; i++) {
			arr.add(i);
			printNumbersUptoN(arr, n, i + 1);
			arr.removeLast();
		}
	}

//	n = 1;
//	1
//	2
//
//	n=2;
//	1 1
//	1 2
//	2 1
//	2 2
//
//	n=3;
//	1 1 1
//	1 1 2
//	1 2 1
//	1 2 2
//	2 1 1
//	2 1 2
//	2 2 1
//	2 2 2

}