import java.io.*;
import java.util.*;

class BusiestMall {

	static int findBusiestPeriod(int[][] data) {

		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

		for (int[] input : data) {

			int timestamp = input[0];
			int count = input[1];
			int door = input[2];

			int val = map.getOrDefault(timestamp, 0);

			count = door == 1 ? count : -count;
			map.put(timestamp, val + count);

		}

		int prev = 0;
		int res = 0;
        int timestampres = 0;

		for (Integer key : map.keySet()) {
			int prev1 = prev + map.get(key);

			if (prev1 > res) {
				res = prev1;
                timestampres = key;

			}
			
			prev = prev1;
		}

		return timestampres;

	}

	public static void main(String[] args) {
		int[][] data = { { 1487799425, 14, 1 }, { 1487799425, 4, 0 }, { 1487799425, 2, 0 }, { 1487800378, 10, 1 },
				{ 1487801478, 18, 0 }, { 1487801478, 18, 1 }, { 1487901013, 1, 0 }, { 1487901211, 7, 1 },
				{ 1487901211, 7, 0 },{ 1487901211, 17, 1 } };
		System.out.println(findBusiestPeriod(data));
	}

}