package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Jump Game II

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1,
then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000

*/

public class JumpGameII {
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

    public int count() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        // Within previous one's jump range, the farest place you can jump each time
        int far = 0;
        // used to store previous farest jump range
        int farEnd = 0;
        // how many times you have jumped
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if(farEnd == i) {
                // if reach the farest range of previous jump,
                // need to set target range to new "far"
                // count + 1, and reset far
                count++;
                farEnd = far;
                far = 0;
            }
        }
        return count;
    }
}
