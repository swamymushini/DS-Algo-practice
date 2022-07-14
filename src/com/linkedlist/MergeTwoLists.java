package com.linkedlist;

import com.util.Util;

public class MergeTwoLists {

	public static void main(String[] args) {

		ListNode head = Util.prepareLinkedList(new int[] { 5, 8, 20 });
		ListNode head2 = Util.prepareLinkedList(new int[] { 4, 11, 15 });

		Util.printLinkedList(new MergeTwoLists().mergeTwoLists(head, head2));
	}

	public ListNode mergeTwoLists(ListNode A, ListNode B) {

		if (B == null) {
			return A;
		} else if (A == null) {
			return B;
		}

		ListNode temp1 = A;
		ListNode temp2 = B;
		ListNode curNode = B.val >= A.val ? A : B;
		ListNode head = curNode;
		
		if(temp1.val <= temp2.val) {
			temp1 = temp1.next;
		}else {
			temp2 = temp2.next;
		}

		while (temp1 != null && temp2 != null) {

			if (temp1.val <= temp2.val) {
				curNode.next = temp1;
				temp1 = temp1.next;
			} else {
				curNode.next = temp2;
				temp2 = temp2.next;
			}

			curNode = curNode.next;
		}

		if (temp1 == null) {

			while (temp2 != null) {
				curNode.next = temp2;
				temp2 = temp2.next;
				curNode = curNode.next;
			}

		} else if (temp2 == null) {

			while (temp1 != null) {
				curNode.next = temp1;
				temp1 = temp1.next;
				curNode = curNode.next;
			}
		}

		return head;
	}
}
