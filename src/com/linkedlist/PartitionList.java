package com.linkedlist;

import com.util.Util;

public class PartitionList {

	public static void main(String[] args) {

		ListNode head = Util.prepareLinkedList(new int[] { 401, 143, 654, 910, 559, 582, 332, 26, 914, 611, 13, 160,
				883, 212, 100, 341, 999, 436, 95, 969, 210, 181, 318, 330, 753, 422, 180, 271, 127, 299, 10 });

		Util.printLinkedList(new PartitionList().partition(head, 88));
	}

	public ListNode partition(ListNode A, int B) {

		ListNode temp = A;
		ListNode head1 = null;
		ListNode head = null;
		ListNode tail = null;
		ListNode tail1 = null;

		while (temp != null) {

			if (temp.val < B) {

				if (head == null) {
					head = temp;
					head1 = head;
				} else {
					head.next = temp;
					head = head.next;
				}
			} else {

				if (tail == null) {
					tail = temp;
					tail1 = tail;
				} else {
					tail.next = temp;
					tail = tail.next;
				}
			}

			temp = temp.next;
		}

		if (head1 == null || tail1 == null) {
			return A;
		}
		
		tail.next = null;
		head.next = tail1;

		return head1;
	}
}
