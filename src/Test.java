<<<<<<< HEAD
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {

	
	
	public static void main(String[] args) {

		Queue<String> pq = new PriorityQueue<String>();
	
	}
	
	public class Bal{
		
	}
	
	
=======
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.trees.TreeNode;

public class Test {

	public static void main(String[] args) {
//		ArrayList<Integer> recoverTree = new Test().recoverTree(Util.getSampleBSTree());
//		System.out.println(recoverTree);
		
		Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
		System.out.println(timestamp);
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

>>>>>>> branch 'master' of https://github.com/swamymushini/DS-Algo-practice.git
}
