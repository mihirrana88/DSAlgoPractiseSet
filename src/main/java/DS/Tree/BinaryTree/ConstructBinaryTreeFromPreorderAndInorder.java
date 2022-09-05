package DS.Tree.BinaryTree;

import java.util.HashMap;
import java.util.Map;

/*
Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 
Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.

*/

public class ConstructBinaryTreeFromPreorderAndInorder {
    public int[] pre = null;
    public int[] in = null;
    Map<Integer, Integer> map = new HashMap<>();
    int start;
    int prelen;

    public void getInputLength(int len){
        pre = new int[len];
        in = new int[len];
    }

    public void acceptPreorder(int num, int index){
        if(index < 0 || index >= pre.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        pre[index] = num;
    }

    public void acceptInorder(int num, int index){
        if(index < 0 || index >= in.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        in[index] = num;
    }

    public TreeNode constructBinaryTree(){
        start = 0;
        prelen = pre.length;
        for(int i=0; i<in.length; i++){
            map.put(in[i], i);
        }
        return constructBinaryTree(pre, in, 0, in.length-1);
    }

    public TreeNode constructBinaryTree(int[] pre, int[] in, int startIn, int endIn){
        if(start > prelen || startIn > endIn){
            return null;
        }

        TreeNode root = new TreeNode(pre[start]);
        start++;
        int position = map.get(root.data);

        root.left = constructBinaryTree(pre, in, startIn, position-1);
        root.right = constructBinaryTree(pre, in, position+1, endIn);

        return root;
    }
}
