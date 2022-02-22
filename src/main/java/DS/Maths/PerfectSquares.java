package DS.Maths;

import Exception.InvalidInputArgument;

import java.util.Arrays;

/*
Perfect Squares

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words,
it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while
3 and 11 are not.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

Constraints:

1 <= n <= 104

*/

public class PerfectSquares {
    public Integer n = null;

    public void acceptInput(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public int perfectSquare() {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int target = 1; target<=n; target++)
            for (int remaining = 1; remaining <=n; remaining++){
                int square = remaining * remaining;
                if (target - square < 0)
                    break;
                dp[target] = Math.min(dp[target], 1+ dp[target-square]);
            }
        return dp[n];
    }

    public int perfectSquareV2() {
        if(Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n))) return 1;
        while(n % 4 == 0) n /= 4;           // remove 4^a term
        if(n % 8 == 7) return 4;           // check if the number now is in the form of (8b + 7)
        for(int i = 1; i*i <= n; ++i){
            int base  = (int)Math.sqrt(n - i * i);
            if(base * base == (n - i * i)) return 2;
        }
        return 3;
    }
}
