package DS.Strings;

import Exception.InvalidInputArgument;

/*
Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
*/

public class LongestCommonPrefix {
    public String[] strings = null;

    public void getInputLength(int len){
        strings = new String[len];
    }

    public void acceptInput(String str, int index){
        if(index < 0 || index >= strings.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        strings[index] = str;
    }

    public String longestCommonPrefix() throws Exception {

        if (null == strings || strings.length == 0){
            throw new InvalidInputArgument(strings);
        }

        if(strings.length == 1){
            return strings[0];
        }

        int minLen = getMinimumLen();

        if(minLen == 0){
            return "";
        }

        String lcp = "";

        for(int i=0; i<minLen; i++){

            for(int j=1; j<strings.length; j++){
                if(strings[0].charAt(i) != strings[j].charAt(i)){
                    return lcp;
                }
            }

            lcp = lcp+strings[0].charAt(i);
        }

        return lcp;
    }

    public int getMinimumLen(){
        int min = strings[0].length();
        for(int i=1; i<strings.length; i++){
            if(strings[i].length() == 0){
                return 0;
            }
            min = Math.min(strings[i].length(), min);
        }
        return min;
    }
}
