package com.linkedlist;

/**
 * Definition for singly-linked list. class ListNode { public int val; public
 * ListNode next; ListNode(int x) { val = x; next = null; } }
 */
public class DesignLinkedList {

	static ListNode head;
	static int len = 0;

	public static void main(String[] args) {
		new DesignLinkedList().solve(new int[][] { { 2, 6, 0 }, { 1, 17, -1 }, { 1, 19, -1 }, { 2, 16, 1 },
				{ 1, 13, -1 }, { 3, 3, -1 }, { 1, 19, -1 } });
	}

	public ListNode solve(int[][] A) {
		head = null;
		len = 0;

		for (int[] arr : A) {

			int opr = arr[0];
			int val = arr[1];
			int ind = arr[2];

			// System.out.print(opr+" "+val+" "+ind+" ");

			switch (opr) {

			case 0:
				insert_node(0, val);
				break;
			case 1:
				insert_node(len, val);
				break;
			case 2:
				insert_node(ind, val);
				break;
			case 3:
				delete_node(val);
				break;

			}
		}

		return head;
	}

	public static void insert_node(int pos, int val) {
		if (pos > len + 1)
			return;

		if (head == null) {
			head = new ListNode(val);
		} else if (pos <= 0) {
			ListNode new1 = new ListNode(val);
			new1.next = head;
			head = new1;
		} else {
			ListNode prev = head;
			int curPos = 0;

			while (curPos < pos - 1) {
				prev = prev.next;
				curPos++;
			}

			if (prev.next == null)
				prev.next = new ListNode(val);
			else {
				ListNode temp = prev.next;
				prev.next = new ListNode(val);
				prev.next.next = temp;
			}

		}

		len++;
	}

	public static void delete_node(int pos) {
		if (pos > len) {
			return;
		}

		if (pos == 0) {
			head = head.next;
		} else {
			int curPos = 0;
			ListNode prev = head;

			while (curPos < pos - 1) {
				prev = head.next;
				curPos++;
			}

			ListNode del = prev.next;
			prev.next = del.next;

		}

		len--;
	}

	public static ListNode deleteMid(ListNode A) {

		ListNode slow = A;
		ListNode fast = A;
		ListNode prev = null;

		while (fast != null && fast.next != null) {

			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (prev == null)
			return null;

		prev.next = slow.next;

		return A;
	}
	
	 public int MIddleElement(ListNode A) {

	        ListNode slow = A;
	        ListNode fast = A;

	        while(fast!=null&&fast.next!=null){

	            slow = slow.next;
	            fast = fast.next.next;

	        }

	        return slow.val;
	    }

}
