package DS.DynamicProgramming;

import Exception.InvalidInputArgument;

/*
Number of Dice Rolls With Target Sum

You have n dice and each die has k faces numbered from 1 to k.

Given three integers n, k, and target, return the number of possible ways (out of the kn total ways)
to roll the dice so the sum of the face-up numbers equals target. Since the answer may be too large,
return it modulo 109 + 7.

Example 1:
Input: n = 1, k = 6, target = 3
Output: 1
Explanation: You throw one die with 6 faces.
There is only one way to get a sum of 3.

Example 2:
Input: n = 2, k = 6, target = 7
Output: 6
Explanation: You throw two dice, each with 6 faces.
There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.

Example 3:
Input: n = 30, k = 30, target = 500
Output: 222616187
Explanation: The answer must be returned modulo 109 + 7.


Constraints:

1 <= n, k <= 30
1 <= target <= 1000

*/

public class DiceRollsWithTargetSum {
    public Integer n = null;
    public Integer k = null;
    public Integer target = null;

    public void acceptN(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public void acceptK(Integer k) throws Exception {
        if(null == k){
            throw new InvalidInputArgument(k);
        }
        this.k = k;
    }

    public void acceptTargetNumber(Integer target) throws Exception {
        if(null == target){
            throw new InvalidInputArgument(target);
        }
        this.target = target;
    }

    public int numRollsToTarget() {
        if(target>k*n) {
            return 0;
        }

        int modulo = (int)Math.pow(10,9)+7;

        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                for(int x=1;x<=k;x++){
                    if(j-x<0)
                        continue;
                    dp[i][j] = (dp[i][j] + dp[i-1][j-x])% modulo;
                }
            }
        }
        return dp[n][target];
    }
}
