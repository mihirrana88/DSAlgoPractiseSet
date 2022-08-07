package DS.DynamicProgramming;

import Exception.InvalidInputArgument;

/*
Count Vowels Permutation

Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:
Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".

Example 2:
Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".

Example 3:
Input: n = 5
Output: 68

Constraints:

1 <= n <= 2 * 10^4

*/

public class CountVowelsPermutation {
    public Integer input = null;

    private long[][] dp;
    private int mod = (int)1e9 + 7;

    public void acceptInput(Integer input) throws Exception {
        if(null == input){
            throw new InvalidInputArgument(input);
        }
        this.input = input;
    }

    public int countVowelPermutation() {
        dp = new long[6][input+1];
        if(input == 1) return 5;

        for(int i = 0; i < 5; i++)
            dp[i][0] = 1;

        helper(input,'z');
        return (int)dp[5][input];
    }

    private long helper(int n, char vowel) {
        long ans = 0;
        if(n == 0) return 1;

        if(vowel == 'z') // we are using z for our convenience just to add Permutations of all Vowels
        {
            ans = (ans + helper(n-1,'a') + helper(n-1,'e') + helper(n-1,'i') + helper(n-1,'o') + helper(n-1,'u'))%mod;
            dp[5][n] = ans;
        }
        // from here as per our assumptions of Vowels we will make calls & store results
        else if(vowel == 'a') // for Nth number we would store Result for "a" in dp[0][n]
        {
            if(dp[0][n] != 0) return dp[0][n];
            ans = (ans + helper(n-1,'e'))%mod;
            dp[0][n] = ans;
        }

        else if(vowel == 'e') // for Nth number we would store Result for "e" in dp[1][n]
        {
            if(dp[1][n] != 0) return dp[1][n];
            ans = (ans + helper(n-1,'a') + helper(n-1,'i'))%mod;
            dp[1][n] = ans;
        }

        else if(vowel == 'i') // for Nth number we would store Result for "i" in dp[2][n]
        {
            if(dp[2][n] != 0) return dp[2][n];
            ans = (ans + helper(n-1,'a') + helper(n-1,'e') + helper(n-1,'o') + helper(n-1,'u'))%mod;
            dp[2][n] = ans;
        }

        else if(vowel == 'o') // for Nth number we would store Result for "o" in dp[3][n]
        {
            if(dp[3][n] != 0) return dp[3][n];
            ans = (ans + helper(n-1,'i') + helper(n-1,'u'))%mod;
            dp[3][n] = ans;
        }

        else // for Nth number we would store Result for "u" in dp[4][n]
        {
            if(dp[4][n] != 0) return dp[4][n];
            ans = (ans + helper(n-1,'a'))%mod;
            dp[4][n] = ans;
        }

        return ans;
    }
}
