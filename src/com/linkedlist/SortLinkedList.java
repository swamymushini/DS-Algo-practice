package com.linkedlist;

import com.util.Util;

public class SortLinkedList {

	public static void main(String[] args) {

		ListNode head = Util.prepareLinkedList(new int[] { 5, 6, 1, 2, 8 });

		Util.printLinkedList(new SortLinkedList().sortList(head));
	}

	public ListNode sortList(ListNode A) {

		ListNode right = getMid(A);

		if (right == A) {
			return A;
		}

		ListNode left = sortList(A);
		right = sortList(right);

		return new MergeTwoLists().mergeTwoLists(left, right);
	}

	public ListNode getMid(ListNode A) {

		ListNode slow = A;
		ListNode fast = A;
		ListNode prev = null;

		while (fast != null && fast.next != null) {

			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (prev == null)
			return A;

		prev.next = null;

		return slow;
	}

}
