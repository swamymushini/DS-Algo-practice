package com.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.Util;

public class EqualPartition {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();

		TreeNode node = Util.buildTree(new Integer[][] { { 3 }, { 2, 10 }, { null, null, 5, 20 } });
		new EqualPartition().solve(node,arr);
		
		System.out.println(arr);
		
		int tot = arr.get(arr.size() - 1);
		System.out.println(arr);
		if (tot % 2 == 0 && arr.contains(tot / 2)) {
			System.out.println("YES");
		} else
			System.out.println("NO");

	}
	
//    public int solve(TreeNode a) {
//        Map < Long, Integer > map = new HashMap < > ();
//        long tot = populate(a, map);
//        // since total sum can also be zero
//        if (tot == 0) 
//            return map.getOrDefault(tot, 0) > 1 ? 1 : 0;
//            
//        System.out.println(map);
//            
//        return tot % 2 == 0 && map.containsKey(tot / 2) ? 1 : 0;
//    }
//    public long populate(TreeNode a, Map < Long, Integer > map) {
//        if (a == null) 
//            return 0;
//        long sum = a.val + populate(a.left, map) + populate(a.right, map);
//        map.put(sum, map.getOrDefault(sum, 0) + 1);
//        return sum;
//    }

	int solve(TreeNode node, List<Integer> arr) {

		if (node == null)
			return 0;
		
		int sum = node.val+solve(node.left, arr)+solve(node.right, arr);
		arr.add(sum);
		return sum;
	}

}
