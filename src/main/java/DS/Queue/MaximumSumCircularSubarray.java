package DS.Queue;

import Exception.InvalidInputArgument;

/*
Maximum Sum Circular Subarray

Given a circular integer array nums of length n, return the maximum possible sum of a non-empty
subarray of nums.

A circular array means the end of the array connects to the beginning of the array.
Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i]
is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally,
for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j
with k1 % n == k2 % n.

Example 1:
Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.

Example 2:
Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

Example 3:
Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.

Constraints:

n == nums.length
1 <= n <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104

*/

public class MaximumSumCircularSubarray {
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

    public int maxSubarraySumCircular() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        int tsum=0, maxSum= Integer.MIN_VALUE, minSum= Integer.MAX_VALUE,
                currMax = 0, currMin = 0;

        for(int i: nums) {
            tsum += i;
            currMax += i;
            currMin += i;

            maxSum = Math.max(maxSum, currMax);
            if(currMax < 0)
                currMax = 0;
            minSum = Math.min(minSum, currMin);
            if(currMin > 0)
                currMin = 0;

        }
        if(tsum == minSum)
            return maxSum;

        return Math.max(maxSum, tsum - minSum);
    }
}
