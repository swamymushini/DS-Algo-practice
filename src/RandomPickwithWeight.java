import java.util.Iterator;
import java.util.Random;

import com.util.Util;

public class RandomPickwithWeight {

	int[] w = null;
	int[] prefix = null;
	private Random rand;

	private int totalSum = 0;

	public RandomPickwithWeight(int[] w) {
		this.w = w;

		this.prefix = new int[w.length];

		this.prefix[0] = w[0];

		totalSum = w[0];

		for (int i = 1; i < w.length; i++) {
			totalSum += w[i];
			this.prefix[i] = prefix[i - 1] + w[i];
		}

		rand = new Random();

	}

	public int pickIndex() {

		int target = rand.nextInt(totalSum) + 1;

		System.out.println("rand " + target);

		for (int i = 0; i < w.length; i++) {

			if (target <= prefix[i])
				return i;

		}

		return 0;

	}

	public static void main(String[] args) {

		int[] w = { 1, 3 };

		RandomPickwithWeight rd = new RandomPickwithWeight(w);

		for (int i = 0; i < 10; i++)
			System.out.println(rd.pickIndex());

	}

}
