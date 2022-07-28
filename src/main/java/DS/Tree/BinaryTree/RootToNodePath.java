package DS.Tree.BinaryTree;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    BinaryTree binaryTreeInput = new BinaryTree();
    int nodeVal;

    public void acceptBinaryTreeInput(BinaryTree binaryTreeInput) throws Exception {
        if(null == binaryTreeInput){
            throw new InvalidInputArgument(binaryTreeInput);
        }
        this.binaryTreeInput = binaryTreeInput;
    }

    public void getWindowSize(int nodeVal){
        this.nodeVal = nodeVal;
    }

    public List<Integer> rootToNodePath(){
        if(null == binaryTreeInput.root){
            return new ArrayList<>();
        }
        List<Integer> path = new ArrayList<>();
        getRootToNodePath(binaryTreeInput.root, nodeVal, path);
        return path;
    }

    public boolean getRootToNodePath(TreeNode root, int nodeVal, List<Integer> path){
        if(null == root){
            return false;
        }
        path.add(root.data);

        if(root.data == nodeVal){
            return true;
        }

        if(getRootToNodePath(root.left, nodeVal, path) || getRootToNodePath(root.right, nodeVal, path)){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
}
