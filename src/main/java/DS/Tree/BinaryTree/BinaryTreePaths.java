package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.List;

/*
Binary Tree Paths

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Example 2:
Input: root = [1]
Output: ["1"]

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100

*/

public class BinaryTreePaths {
    BinaryTree binaryTreeInput = new BinaryTree();
    List<String> ans = new ArrayList<>();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public List<String> binaryTreePaths() {
        binaryTreePaths(binaryTreeInput.root, "");
        return ans;
    }

    public void binaryTreePaths(TreeNode root, String path){
        if(null == root){
            return;
        }

        if(path.isEmpty()){
            path = Integer.toString(root.data);
        }else{
            path = path+"->"+(root.data);
        }

        if(null == root.left && null == root.right){
            ans.add(path);
        }

        binaryTreePaths(root.left, new String(path));
        binaryTreePaths(root.right, new String(path));
    }
}
