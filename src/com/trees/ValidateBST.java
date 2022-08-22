package com.trees;

 //range approach
public class ValidateBST {
	
	
    public int isValidBST(TreeNode A) {
        boolean valid = checkBST(A,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return valid?1:0;
    }

    public boolean checkBST(TreeNode A, int min , int max){

        if(A==null){
            return true;
        }

        if(A.val>=min&&A.val<=max){

            return checkBST(A.left,min,A.val-1)&&
                   checkBST(A.right,A.val+1,max);
        }


        return false;
    }
}
