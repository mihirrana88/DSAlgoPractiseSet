package DS.Stack;

import Exception.InvalidInputArgument;

import java.util.Stack;

/*
Decode String

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces,
square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that
digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"


Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].

*/


public class DecodeString {
    public String inputString = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public String decodeString(){
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        int num=0;

        char[] ar= inputString.toCharArray();
        StringBuilder sb= new StringBuilder();

        for(char ch:ar)
        {
            if(ch>='0' && ch<='9')
                num = num*10 + ch-'0';
            else if(ch=='[')
            {
                numStack.push(num);
                strStack.push(sb);
                num=0;
                sb= new StringBuilder();
            }
            else if(ch==']')
            {
                StringBuilder temp= sb;
                sb= strStack.pop();
                int count= numStack.pop();

                for(int i=0;i<count;i++)
                {
                    sb.append(temp);
                }
            }
            else
                sb.append(ch);
        }

        return sb.toString();
    }
}
