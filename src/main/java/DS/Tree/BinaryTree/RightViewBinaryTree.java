package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.List;

/*
Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Example 1:

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

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

public class RightViewBinaryTree {
    BinaryTree binaryTreeInput = new BinaryTree();
    List<TreeNode> levelList = new ArrayList<>();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public void rightViewInBinaryTree(){
        int level = 0;
        rightViewInBinaryTree(binaryTreeInput.root, levelList, level);
        for(TreeNode node : levelList){
            System.out.print(node.data+" ");
        }
    }

    private void rightViewInBinaryTree(TreeNode root, List<TreeNode> levelList, int level){
        if(null == root){
            return;
        }

        if(levelList.size() <= level){
            levelList.add(level, root);
        }else {
            levelList.set(level, root);
        }

        rightViewInBinaryTree(root.left, levelList, level+1);
        rightViewInBinaryTree(root.right, levelList, level+1);
    }
}
