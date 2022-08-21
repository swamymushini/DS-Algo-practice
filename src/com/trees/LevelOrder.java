package com.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.util.Util;

public class LevelOrder {
	
	public static void main(String[] args) {
		TreeNode root = Util.getSampleTree();
		ArrayList<ArrayList<Integer>> list = new LevelOrder().levelOrder(root);
		System.out.println(list);
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		
		Queue<TreeNode> qu = new LinkedList<TreeNode>();
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		
		qu.add(A);
		qu.add(null);
		
		ArrayList<Integer> sub = new ArrayList<>();
		
		while(!qu.isEmpty()) {
			
			TreeNode poll = qu.poll();
			
			if(poll==null) {
				
				arr.add(new ArrayList<>(sub));
				
				if(qu.isEmpty()) {
					break;
				}
				
				sub = new ArrayList<>();
				qu.add(null);
				continue;
			}
				
			
			sub.add(poll.val);
			
			if(poll.left!=null)
				qu.add(poll.left);
			
			if(poll.right!=null)
				qu.add(poll.right);
			
		}
		
		return arr;
	}

}