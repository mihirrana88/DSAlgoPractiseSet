package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

/*
Flatten Binary Tree to Linked List

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the
list and the left child pointer is always null.The "linked list" should be in the same order as a pre-order
traversal of the binary tree.

Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [0]
Output: [0]


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100

Follow up: Can you flatten the tree in-place (with O(1) extra space)?

*/

public class FlattenBinaryTreeToLinkedList {
    BinaryTree binaryTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public void flattenToLinkedList(){
        flatten(binaryTreeInput.root);
    }

    public void flatten(TreeNode root) {
        while(root !=null){
            if(root.left == null){//If the left subtree is empty, consider the right subtree
                root = root.right;
            }else{// The left subtree is not empty, find the most-right node of the left subtree
                TreeNode pre = root.left;
                while(pre.right != null){
                    pre =pre.right;
                }
                // Hang the original right subtree to the rightmost node of the left subtree
                pre.right = root.right;
                // Insert the left subtree into the right subtree, and the left subtree is assigned a null value
                root.right = root.left;
                root.left = null;

                // Consider the next node
                root = root.right;
            }
        }
    }

}
