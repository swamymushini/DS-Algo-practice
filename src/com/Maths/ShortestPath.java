package com.Maths;

public class ShortestPath {

	public static void main(String[] args) {
		double[] departure1 = { 0, 0.2 };
		double[] destination1 = { 7, 0.5 };
		System.out.println("Shortest path: " + solution(departure1, destination1)); // Output: 7.3

		double[] departure2 = { 0.4, 1 };
		double[] destination2 = { 0.9, 3 };
		System.out.println("Shortest path: " + solution(departure2, destination2)); // Output: 2.7

		double[] departure3 = { 0.9, 6 };
		double[] destination3 = { 1.1, 5 };
		System.out.println("Shortest path: " + solution(departure3, destination3)); // Output: 1.2

		double[] departure4 = { 0, 0.4 };
		double[] destination4 = { 1, 0.6 };
		System.out.println("Shortest path: " + solution(departure4, destination4)); // Output: 1.2

		double[] departure5 = { 2.4, 1 };
		double[] destination5 = { 5, 7.3 };
		System.out.println("Shortest path: " + solution(departure5, destination5)); // Output: 1.2
	}

//	0.4 -> 0,1
//	0.8 -> 0,1

	public static double solution(double[] departure, double[] destination) {
		double x1 = departure[0];
		double y1 = departure[1];
		double x2 = destination[0];
		double y2 = destination[1];

		double a = 0;
		double b = 0;

		double c = 0;
		double d = 0;

		if (x1 != Math.floor(x1) && !(Math.floor(x2) > Math.floor(x1))) {
			double right = Math.floor(x1);
			double left = Math.ceil(x1);
			a = x1 + getDistance(x2, right);
			b = Math.abs(1 - x1) + getDistance(x2, left);
		} else {
			a = Math.abs(x1 - x2);
			b = Math.abs(x1 - x2);
		}

		if (y1 != Math.floor(y1) && !(Math.floor(y2) > Math.floor(y1))) {
			double lower = Math.floor(y1);
			double upper = Math.ceil(y1);
			c = y1 + getDistance(y2, lower);
			d = Math.abs(1 - y1) + getDistance(y2, upper);
		} else {
			c = Math.abs(y1 - y2);
			d = Math.abs(y1 - y2);
		}

		return roundToOneDecimal(Math.min(a, b) + Math.min(c, d));
	}

	private static double getDistance(double destination, double start) {
		return Math.abs(start - destination);
	}

	public static double roundToOneDecimal(double value) {
		return Math.round(value * 10) / 10.0;
	}

}
