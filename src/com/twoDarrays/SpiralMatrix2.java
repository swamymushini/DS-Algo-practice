package com.twoDarrays;

public class SpiralMatrix2 {
	
	public static void main(String[] args) {
		System.out.println(new SpiralMatrix2().generateMatrix(5));
	}
	
	public int[][] generateMatrix(int A) {

		int[][] arr = new int[A][A];
		

		int val = 0;
		int top = 0;
		int right = A - 1;
		int left = 0;
		int down = A - 1;

		int i = 0;

		while (top <= down && left <= right) {

			i = top;
			while (i <= right) {
				arr[top][i++] = ++val;
			}

			top++;

			i = top;
			while (i <=down) {
				arr[i++][right] = ++val;
			}

			right--;

    			i = right;
			while (i >= left) {
				arr[down][i--] = ++val;
			}

			down--;

			i = down;

			while (i >= top) {
				arr[i--][left] = ++val;
			}

			left++;

		}

		return arr;
	}
}
