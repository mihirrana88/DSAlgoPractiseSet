package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Jump Game III

Given an array of non-negative integers arr, you are initially positioned at start index of the array.
When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with
value 0.

Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3

Example 2:
Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3

Example 3:
Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.

Constraints:

1 <= arr.length <= 5 * 104
0 <= arr[i] < arr.length
0 <= start < arr.length

*/

public class JumpGameIII {
    public int[] nums = null;
    public int start;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void getWindowSize(int start){
        this.start = start;
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public boolean canReach() {
        return canReach(nums, start);
    }

    private boolean canReach(int[] nums, int start) {
        if(start<0 || start>=nums.length || nums[start]<0)return false;
        if(nums[start]==0)return true;
        nums[start] = -nums[start];
        return (canReach(nums,start+nums[start]) || canReach(nums,start-nums[start]));

    }
}
