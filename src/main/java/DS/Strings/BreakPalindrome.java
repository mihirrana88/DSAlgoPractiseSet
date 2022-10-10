package DS.Strings;

import Exception.InvalidInputArgument;

/*
Break a Palindrome

Given a palindromic string of lowercase English letters palindrome, replace exactly one character
with any lowercase English letter so that the resulting string is not a palindrome and that it is the
lexicographically smallest one possible.

Return the resulting string. If there is no way to replace a character to make it not a palindrome,
return an empty string.

A string a is lexicographically smaller than a string b (of the same length) if in the first position
where a and b differ, a has a character strictly smaller than the corresponding character in b. For example,
"abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth
character, and 'c' is smaller than 'd'.

Example 1:
Input: palindrome = "abccba"
Output: "aaccba"
Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
Of all the ways, "aaccba" is the lexicographically smallest.

Example 2:
Input: palindrome = "a"
Output: ""
Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty
string.

Constraints:

1 <= palindrome.length <= 1000
palindrome consists of only lowercase English letters.

*/

public class BreakPalindrome {
    String palindrome = null;

    public void acceptInputString(String palindrome) throws Exception {
        if(null == palindrome || palindrome.length() == 0){
            throw new InvalidInputArgument(palindrome);
        }
        this.palindrome = palindrome;
    }

    public String breakPalindrome() {
        if(palindrome.length() == 1){
            return "";
        }

        for(int i=0; i<palindrome.length()/2; i++){
            if(palindrome.charAt(i) - 'a' > 0){
                if(i==0){
                    return "a"+palindrome.substring(i+1);
                }else{
                    return palindrome.substring(0,i)+'a'+palindrome.substring(i+1);
                }
            }
        }

        for(int i=palindrome.length()-1; i>=palindrome.length()/2; i--){
            if('z' - palindrome.charAt(i) > 0){
                if(i == palindrome.length()-1){
                    return palindrome.substring(0,i) + "b";
                }else{
                    return palindrome.substring(0,i)+"b"+palindrome.substring(i+1);
                }
            }
        }

        return "";
    }
}
