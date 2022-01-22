package DS.Strings;

import Exception.InvalidInputArgument;

/*
KMP Algorithm
*/

/*
Implement strStr()

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr()
and Java's indexOf().

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

Example 3:

Input: haystack = "", needle = ""
Output: 0


Constraints:

0 <= haystack.length, needle.length <= 5 * 104
haystack and needle consist of only lower-case English characters.

*/

public class StringPatternMatch {
    String inputString = null;
    String pattern = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public void acceptInputPattern(String pattern) throws Exception {
        if(null == pattern || pattern.length() == 0){
            throw new InvalidInputArgument(pattern);
        }
        this.pattern = pattern;
    }

    public int matchPatternIntoString() throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }

        if(null == pattern || pattern.length() == 0){
            throw new InvalidInputArgument(pattern);
        }

        if(inputString.length() == pattern.length() && inputString.equals(pattern)){
            return 0;
        }

        if(pattern.length() > inputString.length()){
            return -1;
        }

        int[] lps = getLpsFromInputString();
        int i = 0;
        int j = 0;

        while (i<inputString.length() && j<pattern.length()){
            if(inputString.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }else {
                if(j != 0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }

        if(j == pattern.length()){
            return i - pattern.length();
        }

        return -1;
    }

    private int[] getLpsFromInputString(){
        int[] lps = new int[pattern.length()];
        int i = 0;
        for(int j=1; j<pattern.length(); j++){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[j] = lps[j-1]+1;
                i++;
            }else{
                i = lps[lps[j-1]];
            }
        }
        return lps;
    }
}
