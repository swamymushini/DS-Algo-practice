package com.slidingWindow;

public class LongestSubstringwithUniques {
	public static void main(String[] args) {

		String s = "aabacbebebe";
		int k = 2;
		HashMap<Character, Integer> map = new HashMap<>();

		TreeSet<Integer> set = new TreeSet<>();

		int l = 0;
		int r = 0;

		int res = -1;

		while (r < s.length()) {

			char c = s.charAt(r);

			int curr = r;
			map.compute(c, (key, v) -> {

				if (v != null)
					set.remove(map.get(key));

				return curr;
			});

			set.add(r);

			if (map.size() > k) {
				int frst = set.pollFirst();
				l = frst + 1;
				char leastChar = s.charAt(frst);
				map.remove(leastChar);
			}

			if (map.size() == k) {
				res = Math.max(r - l + 1, res);
			}

			r++;
		}

		System.out.println(res);

	}

}
