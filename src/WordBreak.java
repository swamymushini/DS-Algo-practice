import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static void main(String[] args) {

		boolean wordBreak = wordBreak("leetcode", new ArrayList<String>() {
			{
				add("leet");
				add("code");
			}
		});
		
		System.out.println(wordBreak);
	}

	public static boolean wordBreak(String s, List<String> wordDict) {

		Set<String> set = new HashSet<>();
		set.addAll(wordDict);

		int l = 0;
		int r = 1;

		while (l < r && r <= s.length()) {

			String val = s.substring(l, r);

			if (set.contains(val)) {
				l = r;
				r = r + 1;

				if (r >= s.length()) {
					return true;
				}

			} else {
				r++;
			}

		}

		return false;
	}
}