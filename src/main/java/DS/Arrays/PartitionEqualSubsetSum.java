package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Partition Equal Subset Sum

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into
two subsets such that the sum of elements in both subsets is equal.


Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100

*/

public class PartitionEqualSubsetSum {
    public int[] nums = null;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public boolean subsetsum(int nums[],int n,int sum)
    {
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=sum;i++)
        {
            dp[0][i]=false;
        }
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(nums[i-1]<=j)
                {
                    dp[i][j]=(dp[i-1][j-nums[i-1]])||(dp[i-1][j]);
                }
                else if(nums[i-1]>j)
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public boolean canPartition() {

        int n=nums.length;
        int sum=0;
        for(int i:nums)
        {
            sum=sum+i;
        }
        if(sum%2!=0)
        {
            return false;
        }
        else if(sum%2==0)
        {
            return subsetsum(nums,n,sum/2); //for above example as like sum of elements is 22 then we just need to find only half the part of the subset sum which is 11
        }
        return false;
    }
}
