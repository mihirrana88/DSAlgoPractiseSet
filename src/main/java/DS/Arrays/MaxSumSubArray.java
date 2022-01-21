package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Moore's voting Algorithm
*/

/*
Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:

Input: nums = [1]
Output: 1

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

*/

public class MaxSumSubArray {
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

    public int getMaxSumOfSubArrayV1() throws Exception {
        if(nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        if (nums.length == 1){
            return nums[0];
        }

        int maxSum = nums[0];
        int tempSum = maxSum;

        for(int i=1; i<nums.length; i++){
            tempSum = nums[i] + tempSum;

            if(tempSum > maxSum){
                maxSum = tempSum;
            }

            if(nums[i] > maxSum){
                maxSum = nums[i];
            }

            if(nums[i] > tempSum){
                tempSum = nums[i];
            }
        }

        return maxSum;
    }

    public int getMaxSumOfSubArrayV2() throws Exception {
        if(nums.length == 0){
            throw new InvalidInputArgument(nums);
        }
        if(nums.length == 1){
            return nums[0];
        }

        int maxSum = nums[0];
        int tempSum = maxSum;
        for(int i=1; i<nums.length; i++){
            tempSum = Math.max(tempSum+nums[i], nums[i]);
            maxSum = Math.max(tempSum, maxSum);
        }

        return maxSum;
    }


}
