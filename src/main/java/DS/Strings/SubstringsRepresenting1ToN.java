package DS.Strings;

import Exception.InvalidInputArgument;

/*
Binary String With Substrings Representing 1 To N

Given a binary string s and a positive integer n, return true if the binary representation of all the integers
in the range [1, n] are substrings of s, or false otherwise.

A substring is a contiguous sequence of characters within a string.

Example 1:
Input: s = "0110", n = 3
Output: true

Example 2:
Input: s = "0110", n = 4
Output: false

Constraints:

1 <= s.length <= 1000
s[i] is either '0' or '1'.
1 <= n <= 109

*/

public class SubstringsRepresenting1ToN {
    String inputString = null;
    int n;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public void getN(int n){
        this.n = n;
    }

    public boolean queryString() {
        for (int i = n; i > n / 2; --i)
            if (!inputString.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}
