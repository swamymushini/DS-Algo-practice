import java.util.Iterator;
import java.util.Random;

public class RandomPasswordGen {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(generateRandomChars());

		}

	}

	public static String generateRandomChars() {

		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercase = "abcdefghjiklmnopqrstuvwxyz";
		String numeric = "1234567890";
		String specialChar = "@%+#$";

		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			sb.append(uppercase.charAt(random.nextInt(uppercase.length())));
		}

		for (int i = 0; i < 4; i++) {
			sb.append(specialChar.charAt(random.nextInt(specialChar.length())));
		}

		for (int i = 0; i < 4; i++) {
			sb.append(lowercase.charAt(random.nextInt(lowercase.length())));
		}
		for (int i = 0; i < 4; i++) {
			sb.append(numeric.charAt(random.nextInt(numeric.length())));
		}

		return sb.toString();
	}
}
