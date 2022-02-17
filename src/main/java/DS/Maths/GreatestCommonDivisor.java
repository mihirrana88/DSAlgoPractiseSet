package DS.Maths;

import Exception.InvalidInputArgument;

/*
Find Greatest Common Divisor of Array

Given an integer array nums, return the greatest common divisor of the smallest number and
largest number in nums.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both
numbers.

Example 1:

Input: nums = [2,5,6,9,10]
Output: 2
Explanation:
The smallest number in nums is 2.
The largest number in nums is 10.
The greatest common divisor of 2 and 10 is 2.

Example 2:

Input: nums = [7,5,6,8,3]
Output: 1
Explanation:
The smallest number in nums is 3.
The largest number in nums is 8.
The greatest common divisor of 3 and 8 is 1.

Example 3:

Input: nums = [3,3]
Output: 3
Explanation:
The smallest number in nums is 3.
The largest number in nums is 3.
The greatest common divisor of 3 and 3 is 3.

Constraints:

2 <= nums.length <= 1000
1 <= nums[i] <= 1000

*/

public class GreatestCommonDivisor {
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

    public int greatestCommonDivisor() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        int gcd = 1;
        int minNum = nums[0];
        int maxNum = nums[0];

        for(int i=1; i<nums.length; i++){
            if(minNum > nums[i]){
                minNum = nums[i];
            }
            if(maxNum < nums[i]){
                maxNum = nums[i];
            }
        }

        for(int i=1; i<=maxNum; i++){
            if(minNum%i == 0 && maxNum%i == 0){
                if(gcd<i){
                    gcd = i;
                }
            }
        }

        return gcd;
    }
}
