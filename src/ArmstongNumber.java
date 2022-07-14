import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArmstongNumber {

	static Map<Integer, Integer> cubes = new HashMap<>();

	static boolean domore(int N) {

		return false;
	}

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);

		int len = Integer.valueOf(myObj.nextLine());
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;

		int i = 0;
		int[] arr = new int[len];

		while (i < len) {

			arr[i] = Integer.valueOf(myObj.nextLine());

			i++;

		}

		for (i = 0; i < arr.length; i++) {

			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);

		}

		System.out.println(max);
		System.out.println(min);

	}

	public static void maind(String[] args) {

		Scanner myObj = new Scanner(System.in);

		String numb = myObj.nextLine();

		int N = Integer.valueOf(myObj.nextLine());
		int min = Integer.MIN_VALUE;

		int num = 1;
		while (num <= N) {
			int i = num;

			int sum = 0;
			while (i > 0) {

				if (cubes.containsKey(i)) {
					sum = sum + cubes.get(i);
					break;
				}

				int rem = i % 10;
				if (cubes.containsKey(rem)) {
					sum = sum + cubes.get(rem);
				} else {
					int cube = (int) Math.pow(rem, 3);
					cubes.put(rem, cube);
					sum = sum + cube;
				}

				i = i / 10;

			}

			cubes.put(num, sum);
			if (sum == num) {
				System.out.println(num);
			}

			num++;
		}
	}
}