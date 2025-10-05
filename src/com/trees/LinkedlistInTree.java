package com.trees;

import com.linkedlist.ListNode;

public class LinkedlistInTree {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

     public static void main(String[] args) {
        // Create the linked list: [2, 2, 1]
        ListNode head = new ListNode(2);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);

        // Create the binary tree: [2, null, 2, null, 2, null, 1]
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);

        // Create an instance of the class and call isSubPath
        LinkedlistInTree solution = new LinkedlistInTree();
        boolean result = solution.isSubPath(head, root);

        // Print the result
        System.out.println("Is SubPath: " + result);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {

        return traverse(head, root, head);
    }

    public boolean traverse(ListNode head, TreeNode root, ListNode curr) {

        if (curr == null)
            return true;

        if (root == null)
            return false;

        boolean contains = false;

        if (curr.val == root.val) {

            contains = traverse(head, root.left, curr.next);

            contains = contains || traverse(head, root.right, curr.next);

        } else if (!contains && head.val == root.val) {

            contains = traverse(head, root.left, head.next);

            contains = contains || traverse(head, root.right, head.next);

        } else if (!contains) {

            contains = traverse(head, root.left, head);

            contains = contains || traverse(head, root.right, head);

        }

        return contains;
    }

}
