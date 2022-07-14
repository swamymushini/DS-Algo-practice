public class PerfectSquare {

	public static void main(String[] args) {

		System.out.println(solve(1065024));
	}

	public static int solve(int num) {

		int l = 0;
		int r = num;
		return binarySearch(num, l, r);

	}

	static int binarySearch(int num, int l, int r) {

		int mid = (l + r) / 2;

		if (l <= r) {

			if ((double)(mid * mid )== num) {
				return mid;
			} else if ((double)mid * mid > num) {
				r = mid-1;
				return binarySearch(num, l, r);
			} else {
				l = mid + 1;
				return binarySearch(num, l, r);
			}

		}
		return -1;
	}

}
