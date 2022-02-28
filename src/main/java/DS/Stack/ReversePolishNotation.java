package DS.Stack;

import Exception.InvalidInputArgument;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

public class ReversePolishNotation {
    public String[] inputString = null;

    public void acceptInput(String input) throws Exception {
        if(null == input || input.length() == 0){
            throw new InvalidInputArgument(input);
        }
        char[] inputCharArray = input.toCharArray();
        this.inputString = new String[inputCharArray.length];
        for (int i=0; i < inputCharArray.length; i++){
            this.inputString[i] = String.valueOf(inputCharArray[i]);
        }
    }

    public int evaluateReversePolishNotation() throws Exception {
        if(inputString ==  null || inputString.length == 0){
            throw new InvalidInputArgument(inputString);
        }

        Stack<Integer> stack = new Stack<Integer>();
        Set<String> operators = new HashSet<>(Arrays.asList("+","-","/","*"));
        int res = 0;
        for(String str: inputString){
            if(operators.contains(str)){ // If the str is an operator then pop 2 elements;
                // evaluate their result and push it to stack
                int num2 = stack.pop();
                int num1 = stack.pop();
                if(str.equals("+")) res = num1 + num2;
                if(str.equals("-")) res = num1 - num2;
                if(str.equals("/")) res = num1 / num2;
                if(str.equals("*")) res = num1 * num2;
                stack.push(res);
            }
            else{
                stack.push(Integer.parseInt(str)); // otherwise just push the str because its an operand
            }
        }
        return stack.pop();
    }
}
