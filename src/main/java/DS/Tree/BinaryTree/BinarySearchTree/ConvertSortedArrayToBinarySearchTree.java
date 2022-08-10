package DS.Tree.BinaryTree.BinarySearchTree;

import Exception.InvalidInputArgument;

/*
Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order,
convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every
node never differs by more than one.

Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.

*/

public class ConvertSortedArrayToBinarySearchTree {
    BinarySearchTree bst = new BinarySearchTree();
    public int[] nums = null;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public BSTNode sortedArrayToBST() {

        if(nums.length == 0) return null;

        return helper(nums, 0, nums.length - 1);

    }

    private BSTNode helper(int[] nums, int low, int high) {
        if(low > high) // tree is completed
            return null;

        int mid = low + (high - low) / 2; // avoids integer overflow
        BSTNode node = new BSTNode(nums[mid]);

        node.left = helper(nums, low, mid - 1);
        node.right = helper(nums, mid + 1, high);

        return node;
    }
}
