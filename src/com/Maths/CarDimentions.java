package com.Maths;

//https://app.codesignal.com/company-challenges/uber/XHNFMPBYsqNyhx9PP
public class CarDimentions {

	public static void main(String[] args) {
		int[] carDimensions = { 3, 2 }; // Dimensions of the car
		int[][] parkingLot = { { 1, 0, 1, 0, 1, 0 }, { 1, 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 1 } }; // Parking
																															// lot
																															// matrix
		int[] luckySpot = { 1, 1, 2, 3 }; // Coordinates of the lucky spot

		boolean result3 = new CarDimentions().solution(carDimensions, parkingLot, luckySpot);
		System.out.println("Result for third input: " + result3);

	}

	boolean solution(int[] carDimensions, int[][] parkingLot, int[] luckySpot) {

		int x1 = luckySpot[0];
		int y1 = luckySpot[1];

		int x2 = luckySpot[2];
		int y2 = luckySpot[3];

		boolean carFits = check1(x1, y1, x2, y2, carDimensions) || check2(x1, y1, x2, y2, carDimensions);

		boolean anyBlocks = checkBlocks(x1, y1, x2, y2, parkingLot);

		boolean wayClear = checkClearanceLeft(x1, y1, x2, y1, parkingLot)
				|| checkClearanceRight(x1, y2, x2, y2, parkingLot) || checkClearanceTop(x1, y1, x1, y2, parkingLot)
				|| checkClearanceDown(x2, y1, x2, y2, parkingLot);

		return carFits && anyBlocks && wayClear;
	}

	boolean check1(int x1, int y1, int x2, int y2, int[] carDimensions) {

		if (y2 - y1 + 1 < carDimensions[0])
			return false;

		if (x2 - x1 + 1 < carDimensions[1])
			return false;

		return true;
	}

	boolean check2(int x1, int y1, int x2, int y2, int[] carDimensions) {

		if (y2 - y1 + 1 < carDimensions[1])
			return false;

		if (x2 - x1 + 1 < carDimensions[0])
			return false;

		return true;

	}

	boolean checkClearanceLeft(int x1, int y1, int x2, int y2, int[][] parkingLot) {

		for (int i = x1; i <= x2; i++) {

			for (int j = 0; j < y1; j++) {

				if (parkingLot[i][j] == 1)
					return false;

			}

		}

		return true;
	}

	boolean checkClearanceRight(int x1, int y1, int x2, int y2, int[][] parkingLot) {

		for (int i = x1; i <= x2; i++) {

			for (int j = y1 + 1; j < parkingLot[0].length; j++) {

				if (parkingLot[i][j] == 1)
					return false;

			}

		}

		return true;
	}

	boolean checkClearanceTop(int x1, int y1, int x2, int y2, int[][] parkingLot) {

		for (int i = 0; i < x2; i++) {

			for (int j = y1; j < y2; j++) {

				if (parkingLot[i][j] == 1)
					return false;

			}

		}

		return true;
	}

	boolean checkClearanceDown(int x1, int y1, int x2, int y2, int[][] parkingLot) {

		for (int i = x1 + 1; i < parkingLot.length; i++) {

			for (int j = y1; j < y2; j++) {

				if (parkingLot[i][j] == 1)
					return false;

			}

		}

		return true;
	}

	boolean checkBlocks(int x1, int y1, int x2, int y2, int[][] parkingLot) {

		for (int i = x1; i <= x2; i++) {

			for (int j = y1; j <= y2; j++) {

				if (parkingLot[i][j] == 1)
					return false;

			}

		}

		return true;
	}

}
