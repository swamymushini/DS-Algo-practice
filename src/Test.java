import java.util.ArrayList;

import com.trees.TreeNode;
import com.util.Util;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> recoverTree = new Test().recoverTree(Util.getSampleBSTree());
		System.out.println(recoverTree);
	}

	public ArrayList<Integer> recoverTree(TreeNode A) {
		ArrayList<Integer> res = new ArrayList<Integer>();

		TreeNode curr = A;
		while (curr != null) {

			if (curr.left != null) {

				TreeNode temp = curr.left;

				while (temp.right != null && temp.right != curr) {
					temp = temp.right;
				}

				if (temp.right == null) {
					temp.right = curr;
					curr = curr.left;
				} else {
					res.add(curr.val);
					curr = curr.right;
					temp.right = null;
					continue;
				}

			} else {
				res.add(curr.val);
				curr = curr.right;
			}
		}
		
		int a = 0;
		int i = 1;
		for (; i < res.size(); i++) {

			if (res.get(i - 1) > res.get(i)) {
				a = res.get(i - 1);
				break;
			}

		}

		int b = res.get(i);
		i=i+1;
		for (; i < res.size(); i++) {

			if (res.get(i - 1) > res.get(i)) {
				b = res.get(i);
				break;
			}

		}
		
		System.out.println(res);
		res = new ArrayList<Integer>();
		res.add(b);
		res.add(a);

		return res;
	}

}
