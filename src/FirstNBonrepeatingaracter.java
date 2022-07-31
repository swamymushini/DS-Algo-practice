import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNBonrepeatingaracter {

	public static void main(String[] args) {
		System.out.println(new FirstNBonrepeatingaracter().solve("xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr"));
	}

	public String solve(String A) {

		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> map = new HashMap<>();

		Queue<Character> qu = new LinkedList<>();

		for (int i = 0; i < A.length(); i++) {

			char ch = A.charAt(i);

			map.put(ch, map.getOrDefault(ch, 0) + 1);

			if (qu.isEmpty() || qu.peek() != ch) {
				qu.add(ch);
			} else if (qu.peek() == ch) {
				while (map.containsKey(qu.peek())&&map.get(qu.peek()) != 1) {
					qu.poll();
				}
			}

			if (qu.isEmpty()) {
				sb.append('#');
			} else {
				sb.append(qu.peek());
			}

		}
		return sb.toString();
	}
}
