package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Special Sequence

A given input array of length N is known as special sequence only if array element's adjacent pair containing odd
and even numbers.

Example 1:
Input: [1 2 3 4 5]
Output: True

Example 2:
Input: [1 2 2 3 5 8]
Output: False

Example 3:
Input: [8 6 4 12 20]
Output: False

Example 4:
Input: [101 20 51 38]
Output: True

Constraint:
2 <= N <= 10^4
0 <= arr[i] <= 10^4
*/

public class SpecialSequence {
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

    public boolean isSpecialSequence() throws Exception {

        if(null == nums || nums.length == 0 || nums.length == 1){
            throw new InvalidInputArgument(nums);
        }

        int index = 0;
        if(nums[0]%2 != 0){
            index++;
        }

        index++;
        for (int i=1; i < nums.length; i++){
            if((nums[i] % 2 == 0 && index % 2 == 0) || (nums[i] % 2 != 0 && index % 2 != 0)){
                index++;
            }else {
                return false;
            }
        }

        return true;
    }
}
