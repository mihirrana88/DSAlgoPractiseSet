package DS.Strings;

import Exception.InvalidInputArgument;

/*
Sum of Beauty of All Substrings

The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.


Example 1:
Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"],
each with beauty equal to 1.

Example 2:
Input: s = "aabcbaa"
Output: 17


Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.

*/

public class SumBeautySubstrings {
    public String inputString = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public int beautySum() {
        int res = 0;
        int c[] = new int[26];

        for(int i = 0; i < inputString.length(); i++){
            c[inputString.charAt(i) - 'a']++;
            for(int j = i + 1; j < inputString.length(); j++){
                res += helper(inputString, i, j, c);
            }
            c = new int[26];  // creating new array or you can replace count to zero
        }
        return res;
    }

    public int helper(String s,int i, int j, int[] c){

        c[s.charAt(j) - 'a']++;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;

        for(int k : c){
            if(k != 0){
                max = Math.max(max, k);
                min = Math.min(min, k);
                count++;
            }
        }
        if(count > 1) // check for the apperance of same character
            return Math.abs(min - max);
        return 0;
    }
}
