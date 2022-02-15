package DS.Strings;

import Exception.InvalidInputArgument;

public class ReverseString {
    public String inputString = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public void reverseString(){
        if(inputString.length() == 1){
            return;
        }

        char[] inputArray = inputString.toCharArray();
        if (inputString.length() == 2){
            char temp = inputArray[0];
            inputArray[0] = inputArray[1];
            inputArray[1] = temp;
            inputString = String.valueOf(inputArray);
            return;
        }

        for (int i=0; i< inputArray.length/2; i++){
            char temp = inputArray[i];
            inputArray[i] = inputArray[inputArray.length-1-i];
            inputArray[inputArray.length-1-i] = temp;
        }

        inputString = String.valueOf(inputArray);
    }
}
