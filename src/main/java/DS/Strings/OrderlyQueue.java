package DS.Strings;

import Exception.InvalidInputArgument;

import java.util.Arrays;

/*
Orderly Queue

You are given a string s and an integer k. You can choose one of the first k letters of s and append it
at the end of the string..

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

Example 1:
Input: s = "cba", k = 1
Output: "acb"
Explanation:
In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".

Example 2:
Input: s = "baaca", k = 3
Output: "aaabc"
Explanation:
In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".

Constraints:

1 <= k <= s.length <= 1000
s consist of lowercase English letters.

*/

public class OrderlyQueue {
    String inputString = null;
    int k;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public void acceptK(int k){
        this.k = k;
    }

    public String orderlyQueue() {
        if (k == 1) {
            String ans = inputString;
            for (int i = 0; i < inputString.length(); ++i) {
                String temp = inputString.substring(i) + inputString.substring(0, i);
                if (temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        } else {
            char[] chars = inputString.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
