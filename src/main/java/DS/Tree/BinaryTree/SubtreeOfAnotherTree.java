package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

/*
Subtree of Another Tree

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root
with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104

*/

public class SubtreeOfAnotherTree {
    BinaryTree binaryTreeInput = new BinaryTree();
    BinaryTree subTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public void acceptSubTreeInput(BinaryTree subTree) throws Exception {
        if(null == subTree){
            throw new InvalidInputArgument(subTree);
        }
        this.subTreeInput = binaryTreeInput;
    }

    public boolean checkIfSubtree(){
        return isSubtree(binaryTreeInput.root, subTreeInput.root);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        if(this.isSame(root,subRoot)){
            return true;
        }
        return  this.isSubtree(root.left,subRoot) || this.isSubtree(root.right,subRoot);
    }

    boolean isSame(TreeNode p, TreeNode q){
        if(p==null || q==null ) return p==q;
        return p.data==q.data && isSame(p.left,q.left) && isSame(p.right, q.right);
    }
}
