package DS.Tree.BinaryTree.BinarySearchTree;

import Exception.InvalidInputArgument;

import java.util.HashSet;
import java.util.Set;

/*
Two Sum IV - Input is a BST

Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the
BST such that their sum is equal to the given target.

Example 1:
Input: root = [5,3,6,2,4,null,7], k = 9
Output: true

Example 2:
Input: root = [5,3,6,2,4,null,7], k = 28
Output: false

Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105

*/

public class TwoSumBST {
    BinarySearchTree bst = new BinarySearchTree();
    int target;

    public void getTarget(int target){
        this.target = target;
    }

    public void acceptBinaryTreeInput(BinarySearchTree bst) throws Exception {
        if(null == bst){
            throw new InvalidInputArgument(bst);
        }
        this.bst = bst;
    }

    Set<Integer> nums = new HashSet<>();

    public boolean findTarget(){
        return findTarget(bst.root, target);
    }

    public boolean findTarget(BSTNode root, int k) {
        if(null == root){
            return false;
        }

        if(nums.contains(k-root.data)){
            return true;
        }

        nums.add(root.data);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
