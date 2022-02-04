package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining
the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]
Output: [0]

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

*/

public class MoveZeros {
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

    public void moveZerosToEnd()throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        if(nums.length == 1){
            return;
        }

        int i=0;
        int j=1;

        while(i < nums.length && j < nums.length){
            if (nums[i] == 0){
                if(nums[j] != 0){
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                    j++;
                }else {
                    j++;
                }
            }else {
                i++;
                j++;
            }
        }
    }
}
