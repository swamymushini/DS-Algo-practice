package com.linkedlist;

public class FlatlinkedList {

	class ListNode {
		int val;
		ListNode right, down;

		ListNode(int x) {
			val = x;
			right = down = null;
		}
	}

	ListNode flatten(ListNode node) {

		if (node == null || node.right == null) {
			return node;
		}

		ListNode mid = getMid(node);

		ListNode left = flatten(node);

		ListNode right = flatten(mid);

		return merge(left, right);
	}

	private ListNode getMid(ListNode node) {

		ListNode slow = node;
		ListNode fast = node;
		ListNode prev = null;

		while (fast != null && fast.right != null) {
			prev = slow;
			slow = slow.right;
			fast = fast.right;
		}

		if (prev == null)
			return node;

		prev.right = null;

		return slow;
	}

	ListNode merge(ListNode A, ListNode B) {
		ListNode curr1 = A;
		ListNode curr2 = B;
		ListNode dummy = new ListNode(0);
		ListNode res = dummy;
		while (curr1 != null && curr2 != null) {
			if (curr1.val < curr2.val) {
				res.down = curr1;
				curr1 = curr1.down;
				res = res.down;
			} else {
				res.down = curr2;
				curr2 = curr2.down;
				res = res.down;
			}
		}
		if (curr1 != null) {
			res.down = curr1;
		}
		if (curr2 != null) {
			res.down = curr2;
		}
		return dummy.down;
	}
}
