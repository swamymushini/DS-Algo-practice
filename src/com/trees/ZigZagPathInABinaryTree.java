package com.trees;

public class ZigZagPathInABinaryTree {
	private int maxZigZag = 0;
	
	//easy approach
	public int longestZigZag(TreeNode root) {

        if (root != null) {
            longestZigZag(root.left, 1); 
            longestZigZag(root.right, -1);
        }
        return maxZigZag;
    }

    private int longestZigZag(TreeNode node, int direction) {
        
        int left = 0;
        int right = 1;

        if (node == null) {
            return 0;
        }


        if (direction == -1) { 
            left = 1+ longestZigZag(node.left, 1);
            right = longestZigZag(node.right, -1);
        } else {
            right = 1+ longestZigZag(node.right, -1);
            left = longestZigZag(node.left, 1);
        }

        maxZigZag = Math.max(maxZigZag, Math.max(right,left));

        return maxZigZag;
    }
    
    //

	public int longestZigZag(TreeNode root) {
		if (root == null) {
			return 0;
		}

		longestZigZag(root.left, 1); // Start with moving left
		longestZigZag(root.right, -1); // Start with moving right

		return maxZigZag;
	}

	public int longestZigZag(TreeNode node, int direction) {
		if (node == null) {
			return 0;
		}

		int leftZigZag = longestZigZag(node.left, 1);
		int rightZigZag = longestZigZag(node.right, -1);

		int currentZigZag = 0;
		if (direction == 1) {
			currentZigZag = 1 + rightZigZag;
		} else {
			currentZigZag = 1 + leftZigZag;
		}

		maxZigZag = Math.max(maxZigZag, currentZigZag);

		return currentZigZag;
	}
}