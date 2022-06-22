package DS.DynamicProgramming;

import Exception.InvalidInputArgument;

/*
Soup Servings

There are two types of soup: type A and type B. Initially, we have n ml of each type of soup.
There are four kinds of operations:

Serve 100 ml of soup A and 0 ml of soup B,
Serve 75 ml of soup A and 25 ml of soup B,
Serve 50 ml of soup A and 50 ml of soup B, and
Serve 25 ml of soup A and 75 ml of soup B.

When we serve some soup, we give it to someone, and we no longer have it. Each turn,
we will choose from the four operations with an equal probability 0.25.
If the remaining volume of soup is not enough to complete the operation,
we will serve as much as possible. We stop once we no longer have some quantity of both types of soup.

Note that we do not have an operation where all 100 ml's of soup B are used first.

Return the probability that soup A will be empty first,
plus half the probability that A and B become empty at the same time.
Answers within 10-5 of the actual answer will be accepted.

Example 1:
Input: n = 50
Output: 0.62500
Explanation: If we choose the first two operations, A will become empty first.
For the third operation, A and B will become empty at the same time.
For the fourth operation, B will become empty first.
So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.

Example 2:
Input: n = 100
Output: 0.71875

Constraints:

0 <= n <= 109

*/

public class SoupServings {
    public Integer n = null;

    public void acceptInputNumber1(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public double soupServings() {
        //dp[i][j] = 0.25 * dp[i - 100][j] + 0.25 * dp[i - 75][j - 25]
        //         + 0.25 * dp[i - 50][j - 50] + 0.25 * dp[i - 75][j - 25]

        if (n >= 4276){
            return 1;
        }

        n = (n + 24) / 25;
        double[][] dp = new double[n + 1][n + 1];

        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= n; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = 0.5;
                }else if (i == 0){
                    dp[i][j] = 1;
                }else if (j == 0){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] += dp[max(i - 4)][j] * 0.25;
                    dp[i][j] += dp[max(i - 3)][max(j - 1)] * 0.25;
                    dp[i][j] += dp[max(i - 2)][max(j - 2)] * 0.25;
                    dp[i][j] += dp[max(i - 1)][max(j - 3)] * 0.25;
                }
            }
        }

        return dp[n][n];
    }

    private int max(int a){
        return Math.max(a, 0);
    }
}
