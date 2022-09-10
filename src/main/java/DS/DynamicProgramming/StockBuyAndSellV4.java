package DS.DynamicProgramming;

import Exception.InvalidInputArgument;

import java.util.Arrays;

/*
Best Time to Buy and Sell Stock IV

You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:
Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

Example 2:
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

Constraints:

0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000

*/

public class StockBuyAndSellV4 {
    public int[] nums = null;
    int k;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void getK(int k){
        this.k = k;
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return 0;
        }

        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);

        for (int i : prices) {
            buy[0] = Math.max(buy[0], i * -1);
            sell[0] = Math.max(sell[0], buy[0] + i);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - i);
                sell[j] = Math.max(sell[j], buy[j] + i);
            }
        }
        return sell[k - 1];
    }
}
