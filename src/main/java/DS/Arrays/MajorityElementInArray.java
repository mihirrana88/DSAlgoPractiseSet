package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:

n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1

*/

public class MajorityElementInArray {
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

    private int getMajorityElementCandidate() throws Exception {
        if(nums.length == 0){
            throw new InvalidInputArgument(nums);
        }
        if(nums.length == 1){
            return nums[0];
        }

        int majorityCandidate = nums[0];
        int count = 1;
        for(int i=1; i< nums.length; i++){
            if(majorityCandidate == nums[i]){
                count++;
            }else {
                count--;
            }

            if(count == 0){
                majorityCandidate = nums[i];
                count = 1;
            }
        }

        return majorityCandidate;
    }

    public String findMajorityElementFromGivenArray() throws Exception {
        int count = 0;
        Integer majorityCandidate = getMajorityElementCandidate();
        for(int number : nums){
            if(number == majorityCandidate){
                count++;
            }
        }
        if(count > nums.length/2){
            return "Majority element in array is:- "+majorityCandidate;
        }else {
            return "There is no majority element in given array";
        }
    }
}
