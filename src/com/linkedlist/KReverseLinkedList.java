package com.linkedlist;

import com.util.Util;

public class KReverseLinkedList {

	public static void main(String[] args) {

		ListNode head = Util.prepareLinkedList(new int[] { 1, 2, 3, 4, 5, 6 });

		Util.printLinkedList(new KReverseLinkedList().reverseList(head, 3));
	}

	public ListNode reverseList(ListNode head, int k) {

		if (head == null || k == 1)
			return head;

		ListNode temp = null;
		ListNode h1 = head;
		ListNode h2 = null;

		int i = 1;
		while (h1 != null && i <= k) {
			temp = h1;
			h1 = h1.next;
			temp.next = h2;
			h2 = temp;
			i++;
		}

		head.next = reverseList(h1, k);

		return h2;
	}
}
