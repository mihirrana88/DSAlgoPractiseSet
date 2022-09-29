package DS.SlidingWindow;

import java.util.LinkedList;
import java.util.List;

/*
Find K Closest Elements

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b

Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:
Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104

*/

public class FindKClosestElements {
    public int[] nums = null;
    int k;
    int x;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void getK(int k){
        this.k = k;
    }

    public void getX(int x){
        this.x = x;
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    public List<Integer> findClosestElements() {
        List<Integer> res = new LinkedList<>();
        int left = 0, right = nums.length - 1;

        while (right - left > k - 1){
            //shrink the window size from N to K
            if (Math.abs(nums[left] - x) <= Math.abs(nums[right] - x))
                right--;
            else left++;
        }
        while (left <= right) res.add(nums[left++]);
        return res;
    }
}
