package Exception;

public class InvalidInputArgument extends Exception {
    public InvalidInputArgument(int[] input) throws Exception {
        if (null == input){
            throw new Exception("InvalidInputArgument, input=null");
        }
        if (input.length == 0){
            throw new Exception("InvalidInputArgument, empty array");
        }
    }
}
