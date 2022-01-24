package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

/*
Binary Tree Preorder Traversal

Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

*/

public class PreOrderTraversalBinaryTree {
    BinaryTree binaryTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public void preOrderTraversalInBinaryTree(){
        traverseInPreOrder(binaryTreeInput.root);
    }

    private void traverseInPreOrder(TreeNode root){
        if(null == root){
            return;
        }
        System.out.print(root.data+" ");
        traverseInPreOrder(root.left);
        traverseInPreOrder(root.right);
    }
}
