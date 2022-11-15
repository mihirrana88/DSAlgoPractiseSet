package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

public class DepthOfTree {
    BinaryTree binaryTreeInput = new BinaryTree();

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public int leftDepth(){
        TreeNode node = binaryTreeInput.root;
        int depth = 0;
        while (null != node){
            depth++;
            node = node.left;
        }
        return depth;
    }

    public int rightDepth(){
        TreeNode node = binaryTreeInput.root;
        int depth = 0;
        while (null != node){
            depth++;
            node = node.right;
        }
        return depth;
    }
}
