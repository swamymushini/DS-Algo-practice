package com.trees.BST;

import java.util.HashSet;
import java.util.Set;

import com.trees.TreeNode;

//try to solve in SC O(logn)
public class TwoSumBST {
    
    public int t2Sum(TreeNode A, int B) {
        
        Set<Integer> set = new HashSet<>();

        return preOrder(set,A,B)?1:0;
    }

    boolean preOrder(Set<Integer> set,TreeNode A, int B){

        if(A==null)
            return false;

        int val = A.val;    

        if(set.contains(B-val)){
            return true;
        }

        set.add(val);

        return preOrder(set,A.left,B)||preOrder(set,A.right,B);
    }
}
