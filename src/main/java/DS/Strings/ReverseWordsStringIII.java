package DS.Strings;

import Exception.InvalidInputArgument;

/*
Reverse Words in a String III

Given a string s, reverse the order of characters in each word within a sentence while still
preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.

*/

public class ReverseWordsStringIII {
    String s = null;

    public void acceptInputString1(String string1) throws Exception {
        if(null == string1 || string1.length() == 0){
            throw new InvalidInputArgument(string1);
        }
        this.s = string1;
    }

    public String reverseWords() {
        int startIndex = 0;
        int endIndex;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                endIndex = i-1;
                sb = reverseStringChunk(startIndex, endIndex, sb, s);
                sb.append(" ");
                startIndex = i+1;
            }
            if(i == s.length()-1){
                endIndex = i;
                sb = reverseStringChunk(startIndex, endIndex, sb, s);
            }
        }
        return sb.toString();
    }

    public StringBuilder reverseStringChunk(int start, int end, StringBuilder sb, String s){
        for(int i=end; i>=start; i--){
            sb.append(s.charAt(i));
        }
        return sb;
    }
}
