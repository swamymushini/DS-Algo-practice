package com.linkedlist;

public class MiddleElement {

	public ListNode MidElement(ListNode A) {

		ListNode slow = A;
		ListNode fast = A;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}
}
