package Exception;

import DS.Tree.BinaryTree.BinaryTree;

public class InvalidInputArgument extends Exception {
    public InvalidInputArgument(int[] input) throws Exception {
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

    public InvalidInputArgument(BinaryTree input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input BinaryTree=null");
        }
    }
}
