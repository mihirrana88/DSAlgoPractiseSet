package DS.Strings;

import Exception.InvalidInputArgument;

import java.util.HashMap;
import java.util.Map;

/*
Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

public class LongestSubstring {
    String inputString = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public int getLongestSubstringWithoutRepeatingCharacter() throws Exception {
        if(inputString.length() == 1){
            return 1;
        }

        Map<Character, Integer> map = new HashMap<>();
        int lengthOfLongestSubstring = 0;

        for(int j=0, i=0; j< inputString.length(); j++){
            if(map.containsKey(inputString.charAt(j))){
                i = Math.max(inputString.charAt(j), i);
            }

            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, j-i+1);
            map.put(inputString.charAt(j), j+1);
        }

        return lengthOfLongestSubstring;
    }
}
