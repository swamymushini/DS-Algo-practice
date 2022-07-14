package com.linkedlist;

import com.util.Util;

public class ReorderList {

	public static void main(String[] args) {

		ListNode head = Util.prepareLinkedList(new int[] { 1, 2, 3, 4, 5});

		Util.printLinkedList(new ReorderList().reorderList(head));
	}

	public ListNode reorderList(ListNode A) {

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
		ListNode mid = reverse(slow);

		ListNode temp1 = A;
		ListNode temp2 = mid;

		ListNode temp3 = null;
		ListNode temp4 = null;

		while (temp1 != null && temp2 != null) {

			temp3 = temp1.next;
			temp4 = temp2.next;

			temp1.next = temp2;
			temp2.next = temp3;
			
			if(temp3==null) {
				temp2.next = temp4;
			}

			
			temp1 = temp3;
			temp2 = temp4;
		}
		
	
		return A;
	}

	public ListNode reverse(ListNode mid) {

		ListNode temp = mid;
		ListNode h1 = mid;
		ListNode h2 = null;

		while (temp != null) {
			h1 = temp.next;
			temp.next = h2;
			h2 = temp;
			temp = h1;
		}

		return h2;
	}

}
