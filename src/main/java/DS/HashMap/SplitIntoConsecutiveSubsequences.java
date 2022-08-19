package DS.HashMap;

import Exception.InvalidInputArgument;

import java.util.HashMap;
import java.util.Map;

/*
Split Array into Consecutive Subsequences

You are given an integer array nums that is sorted in non-decreasing order.

Determine if it is possible to split nums into one or more subsequences such that both of the following
conditions are true:

Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous integer).
All subsequences have a length of 3 or more.

Return true if you can split nums according to the above conditions, or false otherwise.

A subsequence of an array is a new array that is formed from the original array by deleting some (can be none)
of the elements without disturbing the relative positions of the remaining elements.
(i.e., [1,3,5] is a subsequence of [1,2,3,4,5] while [1,3,2] is not).

Example 1:
Input: nums = [1,2,3,3,4,5]
Output: true
Explanation: nums can be split into the following subsequences:
[1,2,3,3,4,5] --> 1, 2, 3
[1,2,3,3,4,5] --> 3, 4, 5

Example 2:
Input: nums = [1,2,3,3,4,4,5,5]
Output: true
Explanation: nums can be split into the following subsequences:
[1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
[1,2,3,3,4,4,5,5] --> 3, 4, 5

Example 3:
Input: nums = [1,2,3,4,4,5]
Output: false
Explanation: It is impossible to split nums into consecutive increasing subsequences of length 3 or more.

Constraints:

1 <= nums.length <= 104
-1000 <= nums[i] <= 1000
nums is sorted in non-decreasing order.

*/

public class SplitIntoConsecutiveSubsequences {
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

    public boolean isPossible() {

        Map<Integer, Integer> mapOfCount = new HashMap<>();
        for(int i : nums){
            mapOfCount.put(i, mapOfCount.getOrDefault(i, 0)+1);
        }

        int target = 2;
        int i=0;
        while(i<nums.length-2){
            if(mapOfCount.containsKey(nums[i])){
                if(mapOfCount.containsKey(nums[i]) &&
                        mapOfCount.containsKey(nums[i]+1) &&
                        mapOfCount.containsKey(nums[i]+2)){

                    modifyMapOfCount(nums[i], mapOfCount);
                    modifyMapOfCount(nums[i]+1, mapOfCount);
                    modifyMapOfCount(nums[i]+2, mapOfCount);

                    if(!mapOfCount.containsKey(nums[i])){

                    }

                    target--;
                }else{
                    break;
                }
            }else{
                i++;
            }
        }

        if((target==0) ||(target==1 && nums.length==3)){
            return true;
        }

        return false;

    }

    public void modifyMapOfCount(int num, Map<Integer, Integer> mapOfCount){
        if(mapOfCount.get(num)==1){
            mapOfCount.remove(num);
        }else{
            mapOfCount.put(num, mapOfCount.get(num)-1);
        }
    }
}
