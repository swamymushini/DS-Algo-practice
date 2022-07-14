import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {

		Scanner myObj = new Scanner(System.in);

		String numb = myObj.nextLine();

		int num = Integer.valueOf(numb);

		int i = 2;

		while (i <= Math.sqrt(num)) {

			if (num % i == 0) {
				System.out.println("NO");
				return;
			}

			i++;

		}

		System.out.println("YES");

	}
}