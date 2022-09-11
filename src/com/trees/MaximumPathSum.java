package com.trees;
public class MaximumPathSum {
    
    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        solve(root);
        return res;
    }
    
    public int solve(TreeNode root) {
        
        if(root==null)
            return 0;

        int ld = solve(root.left);
        int rd = solve(root.right);
       
        int path = Math.max(Math.max(ld,rd)+root.val,root.val); 
        int maxSum = Math.max(path,ld+rd+root.val);
        res = Math.max(maxSum,res);
        
        return path;
    }
    
}