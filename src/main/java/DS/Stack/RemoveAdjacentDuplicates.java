package DS.Stack;

import Exception.InvalidInputArgument;

import java.util.Stack;

/*
Remove All Adjacent Duplicates In String

You are given a string s consisting of lowercase English letters. A duplicate removal consists of
choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer
is unique.

Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
and this is the only possible move.  The result of this move is that the string is "aaca", of which only
"aa" is possible, so the final string is "ca".

Example 2:
Input: s = "azxxzy"
Output: "ay"

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.

*/

public class RemoveAdjacentDuplicates {
    String inputstring = null;

    public void acceptInputString(String inputstring) throws Exception {
        if(null == inputstring || inputstring.length() == 0){
            throw new InvalidInputArgument(inputstring);
        }
        this.inputstring = inputstring;
    }

    public String removeDuplicates() {

        Stack<Character> st = new Stack<>();

        for(int i=0; i<inputstring.length(); i++){
            char curChar = inputstring.charAt(i);
            if(!st.isEmpty() && st.peek() == curChar){
                while(!st.isEmpty() && st.peek() == curChar){
                    st.pop();
                }
            }else{
                st.push(curChar);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
