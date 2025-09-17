import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class TaskScheduler {
	
	public static void main(String[] args) {
		
		char[] tasks = {'A','A','A','B','B','B'};
		System.out.println(new TaskScheduler().leastInterval(tasks, 0));
		
	}

	public int leastInterval(char[] tasks, int n) {

		TreeMap<Integer, Set<Character>> map = new TreeMap<>();

		HashMap<Character, Integer> tracker = new HashMap<>();

		HashMap<Character, Integer> freQ = new HashMap<>();

		for (char c : tasks) {
			freQ.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}

		for (Character key : freQ.keySet()) {
			int count = freQ.get(key);
			map.compute(count, (k, v) -> v != null ? v : new HashSet<Character>()).add(key);
		}

		int res = 0;

		while (!map.isEmpty()) {

			for (int key : map.keySet()) {

				Set<Character> task1s = map.get(key);

				for (Character c : task1s) {

					if (!tracker.containsKey(c)) {
						res++;
					} else {

						int num = tracker.get(c);

						if ((res+1)-num>= n) {
							res++;
							map.compute(key - 1, (k, v) -> v != null ? v : new HashSet<Character>()).add(c);
						}

					}

//					task1s.remove(c);
					tracker.put(c, res);

				}

				if (task1s.isEmpty()) {
					map.remove(key);
				} else {
					map.put(key, task1s);
				}

			}
		}

		return res;
	}
}
