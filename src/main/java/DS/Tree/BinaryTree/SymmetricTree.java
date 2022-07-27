package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

/*
Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).


Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

Follow up: Could you solve it both recursively and iteratively?

*/

public class SymmetricTree {
    BinaryTree binaryTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public boolean isSymmetric(){
        return isSymmetric(binaryTreeInput.root);
    }

    public boolean isSymmetric(TreeNode root) {

        return root == null || isSymetricHelp(root.left, root.right);

    }

    public boolean isSymetricHelp(TreeNode left, TreeNode right){

        if(left == null || right == null){
            return left == right;
        }

        if(left.data != right.data) return false;

        return isSymetricHelp(left.left, right.right) && isSymetricHelp(left.right, right.left);

    }
}
