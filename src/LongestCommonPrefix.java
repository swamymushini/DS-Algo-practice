
public class LongestCommonPrefix {

	public static void main(String[] args) {

		String[] str = new String[] { "flower", "flow", "flight" };

		String s1 = str[0];

		for (int i = 1; i < str.length; i++) {

			while (str[i].indexOf(s1) != 0) {
				s1 = s1.substring(0, s1.length() - 1);
			}
		}
		
	}
}
