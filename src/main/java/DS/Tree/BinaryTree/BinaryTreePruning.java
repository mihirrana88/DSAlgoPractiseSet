package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

/*
Binary Tree Pruning

Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1
has been removed.

A subtree of a node node is node plus every node that is a descendant of node.

Example 1:
Input: root = [1,null,0,0,1]
Output: [1,null,0,null,1]
Explanation:
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.

Example 2:
Input: root = [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]

Example 3:
Input: root = [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]

Constraints:

The number of nodes in the tree is in the range [1, 200].
Node.val is either 0 or 1.

*/

public class BinaryTreePruning {
    BinaryTree binaryTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode root){
        if(null == root){
            return false;
        }

        boolean left = containsOne(root.left);
        boolean right = containsOne(root.right);

        if(!left){
            root.left = null;
        }

        if(!right){
            root.right = null;
        }

        return root.data == 1 || left || right;
    }
}
