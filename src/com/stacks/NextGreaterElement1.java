package com.stacks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class NextGreaterElement1 {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 3, 4, 2 };

		Queue<Integer> qu = new LinkedList<>();
		qu.add(arr[0]);

		for (int i = 1; i < args.length; i++) {

			if (arr[i] >= qu.peek()) {
				qu.add(arr[i]);
			}else {
				
			}

		}

	}
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && nums2[i] > st.peek()) {
                st.pop();
            }

            if (map.containsKey(nums2[i])) {
                nums1[map.get(nums2[i])] = st.isEmpty() ? -1 : st.peek();
            }

            st.add(nums2[i]);

        }

        return nums1;

    }

}
