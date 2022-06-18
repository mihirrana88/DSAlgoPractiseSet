package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).


Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

*/

public class ZigzagLevelOrderTraversal {
    BinaryTree binaryTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public List<List<Integer>> zigzagLevelOrder() {
        boolean flag=true;

        List<List<Integer>> ans=new ArrayList<>();

        if(binaryTreeInput.root==null) return ans;

        Queue<TreeNode> q=new LinkedList<>();

        q.add(binaryTreeInput.root);

        while(!q.isEmpty()) {

            int n=q.size();

            List<Integer> curr=new ArrayList<>();

            for(int i=0;i<n;i++){
                TreeNode temp=q.poll();


                if(flag) {
                    curr.add(temp.data);
                }
                else {
                    curr.add(0,temp.data);
                }

                if(temp.left!=null) q.add(temp.left);

                if(temp.right!=null) q.add(temp.right);
            }

            flag=!flag;

            ans.add(curr);

        }

        return ans;
    }
}
