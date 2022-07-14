package com.linkedlist;

import com.util.Util;

public class ReverseLinkedList {
	
	public static void main(String[] args) {

		ListNode head = Util.prepareLinkedList(new int[] { 1, 2, 3, 4, 5, 6 });

		Util.printLinkedList(new ReverseLinkedList().reverseList(head));
	}
	
	public ListNode reverseList(ListNode head) {
		
		ListNode temp = head;
		ListNode h1 = head;
		ListNode h2 = null;

		 while(temp!=null){
	            h1 = temp.next;
	            temp.next = h2;
	            h2 = temp;
	            temp = h1;
	        }
		
		return h2;
	}
}
