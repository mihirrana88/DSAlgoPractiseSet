package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Maximum Product Subarray

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.


Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

*/

public class MaximumProductSubarray {
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

    public int maxProduct() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        int ans = nums[0];
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (p == 0) {
                p = nums[i];
            } else {
                p *= nums[i];
            }
            ans = Math.max(ans, p);
        }
        p = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (p == 0) {
                p = nums[i];
            } else {
                p *= nums[i];
            }
            ans = Math.max(ans, p);
        }
        return ans;
    }
}
