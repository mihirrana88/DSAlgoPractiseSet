package DS.Strings;

import Exception.InvalidInputArgument;

import java.util.Arrays;

/*
Largest Number

Given a list of non-negative integers nums, arrange them such that they form the largest number
and return it.

Since the result may be very large, so you need to return a string instead of an integer.

Example 1:
Input: nums = [10,2]
Output: "210"

Example 2:
Input: nums = [3,30,34,5,9]
Output: "9534330"

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109

*/

public class LargestNumber {
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

    public String largestNumber() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        String[] arr = new String[nums.length];
        int idx = 0;
        for (int ele : nums)
            arr[idx++] = ele + "";
        Arrays.sort(arr, (a, b) -> {
            String s1 = a + "" + b;
            String s2 = b + "" + a;
            return s2.compareTo(s1);
        });

        StringBuilder sb = new StringBuilder();
        for (String ele : arr) {
            sb.append(ele);
        }
        if (sb.charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}
