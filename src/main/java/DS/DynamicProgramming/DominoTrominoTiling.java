package DS.DynamicProgramming;

import Exception.InvalidInputArgument;

/*
Domino and Tromino Tiling

You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.

Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very large,
return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if
there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.

Example 1:
Input: n = 3
Output: 5
Explanation: The five different ways are show above.

Example 2:
Input: n = 1
Output: 1

Constraints:

1 <= n <= 1000

*/

public class DominoTrominoTiling {
    public Integer n = null;
    Long[] dp;
    private static final int MOD = 1000000007;
    private int mod = 1000000007;

    public void acceptInput(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public int numTilings() {
        dp = new Long[n+1];
        return (int)helper(n);
    }

    private long helper(int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(dp[n] != null){
            return dp[n];
        }
        long count = 0;
        count = helper(n-1) + helper(n-3) + helper(n-1);

        return dp[n] = count%1000000007;
    }

    public int numTilings2() {
        int a = 1;
        int b = 2;
        int c = 5;

        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }
        if (n == 3) {
            return c;
        }

        int ans = 0;
        for (int i=4; i<=n; i++) {
            ans = ((2 * c) % MOD + a % MOD) % MOD;
            a = b;
            b = c;
            c = ans;
        }

        return ans;
    }

    public int numTilings3() {
        int[] ores = new int[]{1, 1, 2};
        if (n < 3) return ores[n];
        int aux = 0;
        int nres = 0;
        for (int i=3; i<=n; i++) {
            aux = (aux + ores[0]) % mod;
            nres = (((2 * aux) % mod + ores[2]) % mod + ores[1]) % mod;
            ores[0] = ores[1];
            ores[1] = ores[2];
            ores[2] = nres;
        }
        return ores[2];
    }

}
