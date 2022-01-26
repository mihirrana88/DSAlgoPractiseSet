package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

import java.util.Map;
import java.util.TreeMap;

/*
Binary Tree Top View

Given the root of a binary tree, imagine yourself standing on the top of it,
return the values of the nodes you can see ordered from left to right.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [9,3,20,7]

Example 2:

Input: root = [1,null,3]
Output: [1,3]

Example 3:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

*/

public class TopViewBinaryTree {
    BinaryTree binaryTreeInput = new BinaryTree();
    Map<Integer, TreeNode> map = new TreeMap<>();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public void topViewInBinaryTree(){
        int scale = 0;
        topViewInBinaryTree(binaryTreeInput.root, map, scale);
        for (Map.Entry<Integer, TreeNode> entry : map.entrySet()){
            System.out.print(entry.getValue().data+" ");
        }
    }

    private void topViewInBinaryTree(TreeNode root, Map<Integer, TreeNode> map, int scale){
        if(null == root){
            return;
        }

        map.putIfAbsent(scale, root);

        topViewInBinaryTree(root.left, map, scale-1);
        topViewInBinaryTree(root.right, map, scale+1);
    }
}
