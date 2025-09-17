package com.linkedlist;

//2095. Delete the Middle Node of a Linked List
public class DeleteMiddle {

	public static void main(String[] args) {

	}

	public ListNode deleteMiddle(ListNode head) {

		return null;
	}

	public ListNode findMiddle(ListNode head) {

		ListNode temp = head;
		ListNode temp2 = head.next;
		ListNode prev = null;

		while (temp2 != null && temp2.next != null) {
			temp = temp.next;
			temp2 = temp2.next.next;

		}

		return temp;
	}
}