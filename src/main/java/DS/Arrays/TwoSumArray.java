package DS.Arrays;

import Exception.InvalidInputArgument;

import java.util.HashMap;
import java.util.Map;

/*
Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

*/

public class TwoSumArray {
    public int[] nums = null;
    public int target;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void getTargetSum(int target){
        this.target = target;
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public int[] getTwoSumArray() throws Exception {
        if(null == nums || nums.length == 0 || nums.length == 1){
            throw new InvalidInputArgument(nums);
        }

        if (nums.length == 2){
            return nums;
        }

        int[] ans = new int[2];
        Map<Integer, Integer> mapOfIndex = new HashMap<>();
        for (int i=0; i< ans.length; i++){
            int second = target - nums[i];
            if(mapOfIndex.containsKey(second)){
                ans[1] = i;
                ans[0] = mapOfIndex.get(second);
            }
            mapOfIndex.put(nums[i], i);
        }
        return ans;
    }
}
