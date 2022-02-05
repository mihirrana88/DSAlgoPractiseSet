package DS.Strings;

import Exception.InvalidInputArgument;

import java.util.Stack;

/*
Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

    1.Open brackets must be closed by the same type of brackets.
    2.Open brackets must be closed in the correct order.

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

*/

public class ValidParentheses {
    String inputString = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public boolean checkIfValidParentheses() throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }

        if(inputString.length() == 1){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<inputString.length(); i++){
            if(inputString.charAt(i) == '('){
                stack.push(')');
            }else if(inputString.charAt(i) == '{'){
                stack.push('}');
            }else if(inputString.charAt(i) == '['){
                stack.push(']');
            }else if(stack.isEmpty() || inputString.charAt(i) != stack.pop()){
                return false;
            }
        }

        return stack.isEmpty();
    }
}
