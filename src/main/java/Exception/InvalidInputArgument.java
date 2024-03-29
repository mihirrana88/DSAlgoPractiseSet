package Exception;

import DS.Tree.BinaryTree.BinaryTree;
import DS.Tree.BinaryTree.BinarySearchTree.BinarySearchTree;
import DS.Tree.BinaryTree.TreeNode;
import DS.Tree.BinaryTree.BinarySearchTree.BSTNode;

public class InvalidInputArgument extends Exception {
    public InvalidInputArgument(int[] input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input=null");
        }
        if (input.length == 0){
            throw new Exception("InvalidInputArgument, empty array");
        }
    }

    public InvalidInputArgument(int[][] input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input=null");
        }
        if (input.length == 0){
            throw new Exception("InvalidInputArgument, empty array");
        }
    }

    public InvalidInputArgument(String[] input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input=null");
        }
        if (input.length == 0){
            throw new Exception("InvalidInputArgument, empty array");
        }
    }

    public InvalidInputArgument(String input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input=null");
        }
        if (input.length() == 0){
            throw new Exception("InvalidInputArgument, empty string");
        }
    }

    public InvalidInputArgument(Integer input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input=null");
        }
    }

    public InvalidInputArgument(Double input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input=null");
        }
    }

    public InvalidInputArgument(BinaryTree input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input BinaryTree=null");
        }
    }

    public InvalidInputArgument(TreeNode input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input TreeNode=null");
        }
    }

    public InvalidInputArgument(BinarySearchTree input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input BinarySearchTree=null");
        }
    }

    public InvalidInputArgument(BSTNode input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input TreeSearchNode=null");
        }
    }
}
