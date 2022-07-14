package com.linkedlist;

import com.util.Util;

public class ReverseLinkedListII {

	public static void main(String[] args) {

		ListNode head = Util.prepareLinkedList(new int[] { 1, 2, 3 });

		Util.printLinkedList(new ReverseLinkedListII().reverseBetween(head, 1, 2));
	}

	public ListNode reverseBetween(ListNode A, int B, int C) {

		int i = 1;

		ListNode temp = A;
		ListNode prev = null;

		while (i < B) {
			prev = temp;
			temp = temp.next;
			i++;
		}

		if (prev == null)
			return reverseListTillPos(temp, C - B + 1);

		prev.next = reverseListTillPos(temp, C - B + 1);

		return A;
	}

	private ListNode reverseListTillPos(ListNode A, int pos) {

		int i = 1;

		if (A == null||pos == 1) 
			return A;
		
		ListNode temp = A;
		ListNode h1 = A;
		ListNode h2 = null;

		while (temp != null && i <= pos) {
			temp = h1;
			h1 = h1.next;
			temp.next = h2;
			h2 = temp;
			i++;
		}

		A.next = h1;

		return h2;
	}
}
