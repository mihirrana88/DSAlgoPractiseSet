package DS.Tree.BinaryTree.BinarySearchTree;

import Exception.InvalidInputArgument;

import DS.Tree.BinaryTree.BinaryTree;
import DS.Tree.BinaryTree.TreeNode;

public class LowestCommonAncestorBST {
    BinaryTree binaryTreeInput = new BinaryTree();
    TreeNode p;
    TreeNode q;

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public void acceptNodeOne(TreeNode p) throws Exception {
        if(null == p){
            throw new InvalidInputArgument(p);
        }
        this.p = p;
    }

    public void acceptNodeTwo(TreeNode q) throws Exception {
        if(null == q){
            throw new InvalidInputArgument(q);
        }
        this.q = q;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        int curr = root.data;
        if(curr < p.val && curr < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if(curr > p.val && curr > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
