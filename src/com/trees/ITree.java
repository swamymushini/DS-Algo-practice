package com.trees;

import java.util.List;
import java.util.Stack;

public abstract class ITree<T> {

	abstract List<T> inOrderTraversal(TreeNode<T> a);

	abstract List<T> preOrderTraversal(TreeNode<T> a);

	abstract List<T> postOrderTraversal(TreeNode<T> a);

	TreeNode<String> createBinaryTree() {

		TreeNode<String> A = new TreeNode<>("A");
		TreeNode<String> B = new TreeNode<>("B");
		TreeNode<String> C = new TreeNode<>("C");
		TreeNode<String> D = new TreeNode<>("D");
		TreeNode<String> E = new TreeNode<>("E");
		TreeNode<String> F = new TreeNode<>("F");
		TreeNode<String> G = new TreeNode<>("G");
		TreeNode<String> H = new TreeNode<>("H");
		TreeNode<String> I = new TreeNode<>("I");
		TreeNode<String> J = new TreeNode<>("J");

		A.left = B;
		A.right = C;

		B.left = D;
		B.right = E;

		E.left = F;

		C.left = G;
		C.right = H;

		H.right = J;
		H.left = I;

		return A;
	}

	int findHeight(TreeNode<T> A) {

		if (A == null)
			return 0;

		return 1 + Math.max(findHeight(A.left), findHeight(A.right));
	}

	boolean similar(TreeNode<T> A, TreeNode<T> B) {

		if (A == null && B == null) {
			return true;
		} else if (A == null || B == null) {
			return false;
		} else if (A.val != B.val)
			return false;

		return similar(A.left, B.left) && similar(A.right, B.right);
	}

	void invert(TreeNode<T> A, TreeNode<T> B) {

		if (A == null) {
			return;
		}

		if (A.right != null) {
			B.left = new TreeNode<>(A.right.val);
			invert(A.right, B.left);
		}

		if (A.left != null) {
			B.right = new TreeNode<>(A.left.val);
			invert(A.left, B.right);
		}
	}

	public TreeNode<T> invertTree(TreeNode<T> A) {
		if (A == null) {
			return null;
		}
		TreeNode<T> right = invertTree(A.right);
		TreeNode<T> left = invertTree(A.left);
		A.left = right;
		A.right = left;
		return A;
	}

	void copy(TreeNode<T> A, TreeNode<T> B) {

		if (A == null)
			return;

		if (A.left != null) {
			B.left = new TreeNode<>(A.left.val);
			copy(A.left, B.left);
		}

		if (A.right != null) {
			B.right = new TreeNode<>(A.right.val);
			copy(A.right, B.right);
		}
	}

	boolean pathToRoot(TreeNode<T> A, Stack<TreeNode<T>> st, T B) {
		
		if(A==null)
			return false;

		st.push(A);

		if (A.val.equals(B))
			return true;
		
		if (pathToRoot(A.left, st, B) 
				|| pathToRoot(A.right, st, B)) {
			return true;
		}

		st.pop();

		return false;
	}

}
