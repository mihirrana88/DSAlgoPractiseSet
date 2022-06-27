package DS.Arrays;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:
Input: nums = []
Output: []

Example 3:
Input: nums = [0]
Output: []

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105

*/

public class ThreeSum {
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

    public List<List<Integer>> threeSum() throws Exception {

        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0 ; i <= len - 3 ; i++){
            if(i > 0 && nums[i-1] == nums[i])
                continue;
            int start = i + 1;
            int end = len - 1;
            while(start < end){
                if(nums[i] + nums[start] + nums[end] > 0){
                    end--;
                }else if(nums[i] + nums[start] + nums[end] < 0){
                    start++;
                }else{
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    while(nums[start] == nums[start-1] && start < end ){
                        start++;
                    }
                }
            }
        }

        return result;
    }
}
