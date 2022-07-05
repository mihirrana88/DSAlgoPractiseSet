package DS.BinarySearch;

import Exception.InvalidInputArgument;

/*
Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position
of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.


Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

*/

public class FirstLastPositionInSortedArray {
    public int[] nums = null;
    public Integer target = 0;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public int[] searchRange() {
        int firstOccurrence = firstOccurrence(nums, target, nums.length);
        if (firstOccurrence == -1) {
            return new int[] { -1, -1 };
        }
        return new int[] { firstOccurrence, lastOccurrence(nums, target, nums.length) };
    }

    private int firstOccurrence(int[] num, int target, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num[mid] < target) {
                low = mid + 1;
            } else if (num[mid] > target) {
                high = mid - 1;
            } else {
                if (mid == 0 || num[mid - 1] != num[mid]) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    private int lastOccurrence(int[] num, int target, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num[mid] < target) {
                low = mid + 1;
            } else if (num[mid] > target) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || num[mid + 1] != num[mid]) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }
}
