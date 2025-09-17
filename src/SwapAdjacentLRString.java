public class SwapAdjacentLRString {

	public static void main(String[] args) {
		SwapAdjacentLRString s = new SwapAdjacentLRString();
		boolean canTransform = s.canTransform("RXXLRXRXL", "XRLXXRRLX");
		System.out.println(canTransform);
	}

	public boolean canTransform(String start, String result) {

		int l = 0;
		int r = 0;
		int n = start.length();

		while (true) {

			char c1 = start.charAt(l);

			if (c1 == 'X') {
				l++;
				continue;
			}

			char c2 = result.charAt(r);

			if (c2 == 'X') {
				r++;
				continue;
			}

			if (l == n && r == n)
				return true;

			if (l == n || r == n)
				return false;

			if (c1 != c2)
				return false;

			if (c1 == 'L' && l < r)
				return false;

			if (c1 == 'R' && r < l)
				return false;

			l++;
			r++;

		}

	}
}