package com.linkedlist;

import com.util.Util;

public class DeleteDuplicates {

	public static void main(String[] args) {

		ListNode head = Util.prepareLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });

		Util.printLinkedList(new DeleteDuplicates().deleteDuplicates(head));
	}

	public ListNode deleteDuplicates(ListNode A) {

		ListNode temp = A;

		int value = A.val;
		ListNode h1 = null;

		while (true) {

			if (temp.next == null) {

				if (h1 != null)
					h1.next = null;

				break;
			}

			if (h1 != null && temp.val != value) {
				h1.next = temp;
				h1 = null;
			}

			if (h1 == null) {
				value = temp.val;
				h1 = temp;
			}

			temp = temp.next;
		}

		return A;

	}

}
