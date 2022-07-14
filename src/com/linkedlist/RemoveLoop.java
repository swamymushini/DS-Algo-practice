package com.linkedlist;

import com.util.Util;

public class RemoveLoop {

	public static void main(String[] args) {

		ListNode head = Util.prepareLoopedList(new int[] { 6, 5, 5, 3, 8 }, 4);

		Util.printLinkedList(new RemoveLoop().detectCycle(head));
	}

	public ListNode detectCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				slow = head;
				
				while (slow != fast) {
					slow = slow.next;
					prev = fast;
					fast = fast.next;
				}
				
				prev.next = null;
				
				return head;
			}

		}

		return head;
	}

}
