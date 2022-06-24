package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

/*
Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge
connecting them. A node can only appear in the sequence at most once. Note that the path does not need to
pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000

*/

public class BTMaxPathSum {
    BinaryTree binaryTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public int maxPathSum(){
        return maxPathSum(binaryTreeInput.root);
    }

    private int maxPathSum(TreeNode root) {
        int ans[]= new int[1];
        ans[0]= Integer.MIN_VALUE;
        maxSum(root,ans);
        return ans[0];
    }

    private int maxSum(TreeNode root,int res[]){
        if(root==null){
            return 0;
        }

        int lsum= Math.max(0,maxSum(root.left,res));
        int rsum= Math.max(0,maxSum(root.right,res));
        res[0]= Math.max(res[0], root.data+ lsum+rsum);
        return Math.max(root.data+lsum, root.data+rsum);
    }
}
