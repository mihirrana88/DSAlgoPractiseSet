package DS.Tree.BinaryTree;

import java.util.HashMap;
import java.util.Map;

/*
Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the

*/

public class ConstructBinaryTreeFromPostorderAndInorder {
    public int[] post = null;
    public int[] in = null;
    Map<Integer, Integer> map = new HashMap<>();
    int start;

    public void getInputLength(int len){
        post = new int[len];
        in = new int[len];
    }

    public void acceptPreorder(int num, int index){
        if(index < 0 || index >= post.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        post[index] = num;
    }

    public TreeNode constructBinaryTree(){
        start = post.length-1;
        for(int i=0; i< in.length; i++){
            map.put(in[i], i);
        }

        return constructBinaryTree(post, in, 0, in.length-1);
    }

    public TreeNode constructBinaryTree(int[] post, int[] in, int startIn, int endIn){
        if(start < 0 || startIn > endIn){
            return null;
        }

        TreeNode root = new TreeNode(post[start]);
        start--;
        int position = map.get(root.data);

        root.right = constructBinaryTree(post, in, position+1, endIn);
        root.left = constructBinaryTree(post, in, startIn, position-1);

        return root;
    }
}
