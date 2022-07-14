package com.linkedlist;

import com.util.Util;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class SortedListBST {

	public static void main(String[] args) {
		TreeNode sortedListToBST = new SortedListBST().sortedListToBST(Util.prepareLinkedList(new int[] { -10, -3, 0, 5, 9}));
		System.out.println(sortedListToBST);
	}

	public TreeNode sortedListToBST(ListNode head) {

		if (head == null)
			return null;

		ListNode slow = head;
		ListNode fast = head;

		ListNode prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		if (prev == null) {
			return new TreeNode(slow.val);
		}

		prev.next = null;

		TreeNode root = new TreeNode(slow.val);

		ListNode rightHead = slow.next;

		root.left = sortedListToBST(head);
		root.right = sortedListToBST(rightHead);

		return root;
	}

}