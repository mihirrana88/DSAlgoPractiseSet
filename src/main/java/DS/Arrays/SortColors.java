package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Sort Colors

Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent, with the colors in the order red,
white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.


Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

*/

public class SortColors {
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

    public void sortColors() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for(int i=0; i< nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
            }else if(nums[i] == 1){
                oneCount++;
            }else if(nums[i] == 2){
                twoCount++;
            }
        }

        for(int i=0; i<zeroCount; i++){
            nums[i] = 0;
        }
        for (int i=zeroCount; i<zeroCount+oneCount; i++){
            nums[i] = 1;
        }
        for(int i=zeroCount+oneCount; i< nums.length; i++){
            nums[i] = 2;
        }
    }
}
