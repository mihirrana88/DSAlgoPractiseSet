package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Set Mismatch

You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately,
due to some error, one of the numbers in s got duplicated to another number in the set, which results in
repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]

Example 2:
Input: nums = [1,1]
Output: [1,2]

Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104

*/

public class SetMismatch {
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

    public int[] findErrorNums() {
        int[] ans = new int[2];
        int[] check = new int[nums.length + 1];
        for (int num : nums) {
            check[num]++;
        }

        for(int i=1; i<check.length; i++){
            if(check[i] == 0){
                ans[1] = i;
            }

            if(check[i] == 2){
                ans[0] = i;
            }
        }

        return ans;
    }
}
