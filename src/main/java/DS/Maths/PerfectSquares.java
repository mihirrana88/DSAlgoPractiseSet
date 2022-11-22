package DS.Maths;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    /*
    * Intuition

        * First we need to build the squares array that represent the possible square values that we
          can have upto the given number n.
        * Then it becomes a coin-change problem. We need to pick the least amount of values that can
          form our number n.
 
    * */
    public int numSquaresv3() {
        List<Integer> squares = new ArrayList<>();

        int cur = 1;
        // Build the squares array
        while (Math.pow(cur, 2) <= n) {
            squares.add((int) Math.pow(cur++, 2));
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case
        dp[0] = 0;
        for (int i = 1; i < n+1; i++ ) {
            // DP transition
            for (int j = 0; j < squares.size() && squares.get(j) <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i-squares.get(j)]);
            }
        }
        return dp[n];
    }
}
