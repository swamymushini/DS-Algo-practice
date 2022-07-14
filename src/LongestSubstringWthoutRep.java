import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWthoutRep {

	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();

		int maxlen = 0;
		int start = 0;

		for (int i = 0; i < s.length(); i++) {

			Character c = s.charAt(i);

			if (!map.containsKey(c)) {
				maxlen = Math.max(maxlen, (i - start + 1));
			} else {
				int ind = map.get(c);

				if (ind >= start) {

					maxlen = Math.max(maxlen, (i - start));
					start = ind + 1;
				} else {
					maxlen = Math.max(maxlen, (i - start + 1));
				}
			}
			map.put(c, i);
		}

		return maxlen;
	}
	
	
	public int lengthOfLongestSubstring2(String s) {
		
		Set<Character> hs = new HashSet<>();
		
		for (int i = 0; i < s.length(); i++) {
			
			
		}
		
		return 0;
	}

}