import java.util.HashSet;
import java.util.Set;

public class Test2 {

	public static void main(String args[]) {
		System.out.println(new Test2().totalNQueens(4));
	}

	public int totalNQueens(int n) {
		return totalNQueens(0, new HashSet<>(), n, new HashSet<>());
	}

	public int totalNQueens(int i, Set<String> set, int n, Set<Integer> cols) {

		if (i == n) {
			return 1;
		}

		int count = 0;

		for (; i < n; i++) {

			for (int j = 0; j < n; j++) {

				if (canBePlaced(i, j, set, cols, n)) {
					set.add(i + "-" + j);
					cols.add(j);
					count += totalNQueens(i + 1, set, n, cols);
					set.remove(i + "-" + j);
					cols.remove(j);
				}
			}

		}

		return count;
	}

	boolean canBePlaced(int i, int j, Set<String> set, Set<Integer> cols, int n) {

		if (cols.contains(j))
			return false;

		int k = j;
		int l = i;

		while (i - 1 >= 0 && j + 1 < n) {

			j++;
			i--;

			if (set.contains(i + "-" + j))
				return false;

		}

		i = l;
		j = k;

		while (i - 1 >= 0 && j - 1 >= 0) {

			j--;
			i--;

			if (set.contains(i + "-" + j))
				return false;

		}

		return true;
	}

}
