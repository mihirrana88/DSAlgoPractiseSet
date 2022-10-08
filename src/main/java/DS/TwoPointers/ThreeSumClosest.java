package DS.TwoPointers;

import java.util.Arrays;

/*
3Sum Closest

Given an integer array nums of length n and an integer target, find three integers in nums such that the
sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.


Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104

*/

public class ThreeSumClosest {
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

    public int threeSumClosest() {
        Arrays.sort(nums);
        int n = nums.length;
        int closet = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0;i<n;i++){
            int tar = target - nums[i];
            int l = i+1;
            int h = n-1;
            while(l<h){
                int cur = nums[l] + nums[h];
                if(closet>Math.abs(target-(nums[i] + cur))){
                    result = cur+nums[i];
                    closet = Math.abs(target - (cur+nums[i]));
                }
                if(cur==tar){
                    return target;
                }else if(cur>tar){
                    h--;
                }else{
                    l++;
                }
            }
        }
        return result;
    }
}
