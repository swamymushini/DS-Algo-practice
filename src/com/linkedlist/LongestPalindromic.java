package com.linkedlist;

import com.util.Util;

public class LongestPalindromic {

	public static void main(String[] args) {

		ListNode head = Util.prepareLinkedList(new int[] { 1,2,2,3,3,2,2 });

		System.out.println(new LongestPalindromic().solve(head));
	}

	public int solve(ListNode A) {

		int res = 1;

		ListNode h1 = A;
		ListNode h2 = null;
		ListNode temp = A;

		while (temp != null) {
			temp = h1.next;
			h1.next = h2;
			h2 = h1;
			h1 = temp;
			res = Math.max(res, getPalindromeLength(h2, h1));
			if (h1 != null)
				res = Math.max(res, getPalindromeLength(h2, h1.next) + 1);
		}
		return res;
	}

	private int getPalindromeLength(ListNode h1, ListNode h2) {

		int cnt = 0;

		if (h1 == null || h2 == null) {
			return cnt;
		}

		ListNode temp1 = h1;
		ListNode temp2 = h2;

		while (temp1 != null && temp2 != null) {

			if (temp1.val == temp2.val)
				cnt++;
			else
				break;

			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		return cnt * 2;

	}

}
