package DS.DynamicProgramming;

import Exception.InvalidInputArgument;

/*
Combination Sum IV

Given an array of distinct integers nums and a target integer target,
return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

Example 1:
Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.

Example 2:
Input: nums = [9], target = 3
Output: 0

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000

Follow up: What if negative numbers are allowed in the given array? How does it change the problem?
What limitation we need to add to the question to allow negative numbers?

*/

public class CombinationSumIV {
    public int[] nums = null;
    int target;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void getTarget(int target){
        this.target = target;
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public int combinationSum4() {
        int dp[]=new int[target+1];
        return task(nums,target,dp);
    }


    /*
    * nums = [1,2,3], target = 4
    *
    * i=1, j=0
    * dp[1] = dp[1] + dp[i-n[j]] = 0 + 1 = 1
    *
    * i=2, j=0
    * dp[2] = dp[2] + dp[2-1] = 0 + 1 = 1
    * i=2, j=1
    * dp[2] = dp[2] + dp[2-2] = 1 + 1 = 2
    *
    * i=3, j=0
    * dp[3] = dp[3] + dp[3-1] = 0 + 2 = 2
    * i=3, j=1
    * dp[3] = dp[3] + dp[3-2] = 2 + 1 = 3
    * i=3, j=2
    * dp[3] = dp[3] + dp[3-3] = 3 + 1 = 4
    *
    * i=4. j=0
    * dp[4] = dp[4] + [4-1] = 0 + 4 = 4
    * i=4, j=1
    * dp[4] = dp[4] + [4-2] = 4 + 2 = 6
    * i=4, j=2
    * dp[4] = dp[4] + dp[4-3] = 6 + 1 = 7
    *
    *
    * */

    public int task(int n[], int t, int dp[])
    {
        dp[0]=1;
        for(int i=1;i<=t;i++)
        {
            for(int j=0;j<n.length;j++)
            {
                if(i-n[j]>=0)
                {
                    dp[i]+=dp[i-n[j]];
                }
            }
        }
        return dp[t];
    }
}
