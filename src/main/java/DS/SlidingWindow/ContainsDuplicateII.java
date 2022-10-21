package DS.SlidingWindow;

import Exception.InvalidInputArgument;

import java.util.HashMap;
import java.util.Map;

/*
Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the
array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105

*/

public class ContainsDuplicateII {
    public int[] nums = null;
    int k;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void getK(int k){
        this.k = k;
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public boolean containsNearbyDuplicate() {
        if(k==0 || nums.length == 1){
            return false;
        }

        Map<Integer, Integer> windowCount = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(i <= k){
                windowCount.put(nums[i], windowCount.getOrDefault(nums[i], 0)+1);
                if(windowCount.size()<i+1){
                    return true;
                }
            }else{
                int left = windowCount.get(nums[i-k-1]);
                if(left > 1){
                    windowCount.put(nums[i-k-1], left-1);
                }else{
                    windowCount.remove(nums[i-k-1]);
                }

                if(windowCount.containsKey(nums[i])){
                    return true;
                }

                windowCount.put(nums[i], windowCount.getOrDefault(nums[i], 0)+1);
            }

        }

        return false;
    }
}
