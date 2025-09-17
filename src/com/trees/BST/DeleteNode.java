package com.trees.BST;

import com.trees.TreeNode;

public class DeleteNode {

	 public TreeNode deleteNode(TreeNode root, int key) {

	        if (root == null)
	            return null;

	        if (root.val == key) {
	            return delete(root, key);
	        }

	        if (root.val < key) {
	            root.right = deleteNode(root.right, key);
	        } else {
	            root.left = deleteNode(root.left, key);
	        }

	        return root;
	    }

	    public TreeNode delete(TreeNode root, int key) {

	        if (root.right != null && root.left != null){
	            int rightMin = findMin(root.right);
	            root.right = deleteNode(root.right, rightMin);
	            root.val = rightMin;
	            return root;
	        }

	        if (root.right == null)
	            return root.left;
	        else
	            return root.right;

	    }

	    public int findMin(TreeNode root) {
	        
	        if (root.left == null)
	            return root.val;

	        return findMin(root.left);
	    }
}
