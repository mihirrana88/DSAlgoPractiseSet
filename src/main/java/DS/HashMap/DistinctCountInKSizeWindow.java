package DS.HashMap;

import Exception.InvalidInputArgument;

import java.util.HashMap;

/*
Count distinct elements in every window of size k

Given an array of size n and an integer k, return the count of distinct numbers in all windows of size k.

Example 1

Input: arr[] = {1, 2, 1, 3, 4, 2, 3};
       k = 4
Output: 3 4 4 3

Explanation:
First window is {1, 2, 1, 3}, count of distinct numbers is 3
Second window is {2, 1, 3, 4} count of distinct numbers is 4
Third window is {1, 3, 4, 2} count of distinct numbers is 4
Fourth window is {3, 4, 2, 3} count of distinct numbers is 3

Example 2

Input: arr[] = {1, 2, 4, 4};
       k = 2
Output: 2 2 1

Explanation:
First window is {1, 2}, count of distinct numbers is 2
First window is {2, 4}, count of distinct numbers is 2
First window is {4, 4}, count of distinct numbers is 1

*/

public class DistinctCountInKSizeWindow {
    public int[] nums = null;
    int k;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void getWindowSize(int k){
        this.k = k;
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public void getDistinctCountInKSizeWindow() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        if(k > nums.length){
            throw new InvalidInputArgument(nums);
        }

        if(k == 0){
            return;
        }

        HashMap<Integer, Integer> elementCount = new HashMap<>();

        for(int i=0; i<k; i++){
            elementCount.put(nums[i], elementCount.getOrDefault(nums[i], 0)+1);
        }

        System.out.print(elementCount.size()+" ");

        for(int i=k; i<nums.length; i++){
            if(elementCount.get(nums[i-k]) == 1){
                elementCount.remove(nums[i-k]);
            }else {
                elementCount.put(nums[i-k], elementCount.get(nums[i-k])-1);
            }
            elementCount.put(nums[i], elementCount.getOrDefault(nums[i], 0)+1);
            System.out.print(elementCount.size()+" ");
        }
    }
}
