package DS.DynamicProgramming;

/*
Maximum Score from Performing Multiplication Operations

You are given two integer arrays nums and multipliers of size n and m respectively,
where n >= m. The arrays are 1-indexed.

You begin with a score of 0. You want to perform exactly m operations.
On the ith operation (1-indexed), you will:

Choose one integer x from either the start or the end of the array nums.
Add multipliers[i] * x to your score.
Remove x from the array nums.
Return the maximum score after performing m operations.

Example 1:
Input: nums = [1,2,3], multipliers = [3,2,1]
Output: 14
Explanation: An optimal solution is as follows:
- Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
- Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
- Choose from the end, [1], adding 1 * 1 = 1 to the score.
The total score is 9 + 4 + 1 = 14.

Example 2:
Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
Output: 102
Explanation: An optimal solution is as follows:
- Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
- Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
- Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
- Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
- Choose from the end, [-2,7], adding 7 * 6 = 42 to the score.
The total score is 50 + 15 - 9 + 4 + 42 = 102.

Constraints:

n == nums.length
m == multipliers.length
1 <= m <= 103
m <= n <= 105
-1000 <= nums[i], multipliers[i] <= 1000

*/

public class MaxScoreByMultiplication {
    public int[] nums = null;
    public int[] multipliers = null;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void getMultiplierLength(int len){
        multipliers = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public void acceptMultiplier(int num, int index){
        if(index < 0 || index >= multipliers.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        multipliers[index] = num;
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        // For Right Pointer
        int n = nums.length;
        // Number of Operations
        int m = multipliers.length;
        int[] dp = new int[m + 1];

        for (int op = m - 1; op >= 0; op--) {
            int[] next_row = dp.clone();
            // Present Row is now next_Row because we are moving upwards
            for (int left = op; left >= 0; left--) {
                dp[left] = Math.max(multipliers[op] * nums[left] + next_row[left + 1],
                        multipliers[op] * nums[n - 1 - (op - left)] + next_row[left]);
            }
        }
        return dp[0];
    }
}
