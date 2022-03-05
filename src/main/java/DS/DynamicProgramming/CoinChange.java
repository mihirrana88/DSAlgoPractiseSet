package DS.DynamicProgramming;

import Exception.InvalidInputArgument;

/*
Coin Change

You are given an integer array coins representing coins of different denominations and
an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

*/

public class CoinChange {
    public int[] coins = null;
    public Integer amount = 0;

    public void getInputLength(int len){
        coins = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= coins.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        coins[index] = num;
    }

    public void acceptTarget(Integer amount) throws Exception {
        if(null == amount){
            throw new InvalidInputArgument(amount);
        }
        this.amount = amount;
    }

    public int coinChange() {
        int[] dp=new int[amount+1];

        dp[0]=0;

        for(int i=1;i<dp.length;i++)
        {
            int min=Integer.MAX_VALUE-1;

            for (int coin : coins) {
                if (coin <= i) {
                    min = Math.min(min, dp[i - coin]);
                }
            }

            dp[i]=min+1;
        }

        if(dp[amount]==Integer.MAX_VALUE)
            return -1;
        return dp[amount];
    }
}
