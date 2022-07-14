package com.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackTraversal<T> extends ITree<T> {

//	1) Create an empty stack S.
//	2) Initialize current node as root
//	3) Push the current node to S and set current = current->left until current is NULL
//	4) If current is NULL and stack is not empty then
//	a) Pop the top item from stack.
//	b) Print the popped item, set current - popped iten->right
//	c) Go to step 3.
//	5) If current is NULL and stack is empty then we are done.

	@Override
	List<T> inOrderTraversal(TreeNode<T> a) {
		ArrayList<T> res = new ArrayList<>();

		Stack<TreeNode<T>> st = new Stack<>();
		TreeNode<T> curr = a;

		while (!st.isEmpty() || curr != null) {

			if (curr == null) {
				TreeNode<T> pop = st.pop();
				res.add(pop.val);
				curr = pop.right;
			} else {
				st.push(curr);
				curr = curr.left;
			}

		}

		return res;

	}

	@Override
	List<T> preOrderTraversal(TreeNode<T> a) {

		ArrayList<T> res = new ArrayList<>();

		Stack<TreeNode<T>> st = new Stack<>();
		st.push(a);

		while (!st.isEmpty()) {

			TreeNode<T> pop = st.pop();

			res.add(pop.val);

			if (pop.right != null)
				st.push(pop.right);

			if (pop.left != null)
				st.push(pop.left);
		}

		return res;

	}

	@Override
	List<T> postOrderTraversal(TreeNode<T> a) {
		// TODO Auto-generated method stub
		return null;
	}

}
