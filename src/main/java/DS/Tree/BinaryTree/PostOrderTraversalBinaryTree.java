package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

/*
Binary Tree Postorder Traversal

Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

*/

public class PostOrderTraversalBinaryTree {
    BinaryTree binaryTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public void postOrderTraversalInBinaryTree(){
        traversePostOrder(binaryTreeInput.root);
    }

    private void traversePostOrder(TreeNode root){
        if(null == root){
            return;
        }
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.data+" ");
    }
}
