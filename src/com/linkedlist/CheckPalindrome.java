package com.linkedlist;

public class CheckPalindrome {

	public int lPalin(ListNode A) {

		ListNode slow = A;
		ListNode fast = A;
		ListNode prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (prev == null)
			return 1;

		prev.next = null;

		ListNode mid = reverse(slow);

		ListNode temp1 = A;
		ListNode temp2 = mid;

		while (temp1 != null && temp2 != null) {

			if (temp1.val != temp2.val) {
				return 0;
			}

			temp1 = temp1.next;
			temp2 = temp2.next;

		}
		return 1;
	}

	private ListNode reverse(ListNode A) {

		ListNode temp = A;
		ListNode h1 = A;
		ListNode h2 = null;

		while (temp != null) {

			temp = h1.next;
			h1.next = h2;
			h2 = h1;
			h1 = temp;
		}

		return h2;
	}

}
