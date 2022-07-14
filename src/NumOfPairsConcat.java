import java.util.HashMap;
import java.util.Map;

public class NumOfPairsConcat {

	public static void main(String[] args) {
//		System.out.println(new NumOfPairsConcat().numOfPairs(new String[] {"77","77","777","7"}, "7777"));

		System.out.println(
				new NumOfPairsConcat().numOfPairs(new String[] { "88760205", "88", "8", "7602058" }, "887602058"));
	}

	public int numOfPairs(String[] nums, String target) {
		int ct = 0;

		Map<String, Integer> hash = new HashMap<String, Integer>();

		for (int i = 0; i < nums.length; i++) {

			String s1 = nums[i];

			String s2 = null;
			
			int j = target.indexOf(s1);
			
			if (j > 0) {
				s2 = target.substring(0, j);
			} else if (j == 0) {
				s2 = target.substring(s1.length());
			}
			
			if(target.startsWith(s2)) {
				
			}
			
			if(target.endsWith(s2)) {
				
			}
			

			if (hash.containsKey(s2)) {

				int c = hash.get(s2);

				if ((s2 + s1).equals(target)) {
					ct = c + ct;
				}

				if ((s1 + s2).equals(target)) {
					ct = c + ct;
				}
			}

			if (hash.containsKey(s1)) {
				hash.put(s1, hash.get(s1) + 1);
			} else
				hash.put(s1, 1);

		}

		return ct;
	}

}