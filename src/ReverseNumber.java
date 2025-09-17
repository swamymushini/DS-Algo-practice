import java.util.HashMap;
import java.util.Map;

public class ReverseNumber {
    public static int reverse(int number) {
        // Convert the number to a string
        String numString = Integer.toString(number);

        // Use StringBuilder to reverse the string
        String reversedString = new StringBuilder(numString).reverse().toString();

        // Convert the reversed string back to an integer
        int reversedNumber = Integer.parseInt(reversedString);

        return reversedNumber;
    }

    public static void main(String[] args) {
        int number = 12345;
        int reversedNumber = reverse(number);
        System.out.println("Original number: " + number);
        System.out.println("Reversed number: " + reversedNumber);
        Map<String, String> map = new HashMap<>();
        String gopal = "fdshjksfdhgs";
        int hashCode = gopal.hashCode();
        System.out.println(hashCode);
        map.put(gopal, gopal);
    }
}
