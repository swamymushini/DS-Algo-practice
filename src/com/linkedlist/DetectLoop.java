package com.linkedlist;

import com.util.Util;

public class DetectLoop {

	public static void main(String[] args) {

		ListNode head = Util.prepareLoopedList(new int[] { 6, 5, 5, 3, 8 }, 4);

		System.out.println((new DetectLoop().detectCycle(head).val));
	}

	public ListNode detectCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				
				slow = head;
				
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return fast;
			}

		}

		return null;
	}
}
