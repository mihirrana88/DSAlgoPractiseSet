package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

import java.util.LinkedList;
import java.util.Queue;

/*
Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of
its nodes' values. (i.e., from left to right, level by level).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000

*/

public class LevelOrderTraversalBinaryTree {
    BinaryTree binaryTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public void levelOrderTraversalInBinaryTree(){
        if(binaryTreeInput.root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(binaryTreeInput.root);
        queue.add(null);

        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(null == currentNode){
                if(queue.isEmpty()){
                    return;
                }
                queue.add(null);
                continue;
            }
            System.out.print(currentNode.data+" ");
            if(null != currentNode.left){
                queue.add(currentNode.left);
            }
            if(null != currentNode.right){
                queue.add(currentNode.right);
            }
        }
    }
}
