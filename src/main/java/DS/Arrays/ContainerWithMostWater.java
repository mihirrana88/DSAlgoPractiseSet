package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the
two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains
the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104

*/

public class ContainerWithMostWater {
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

    public int getContainerWithMaxWater() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        if(nums.length == 1){
            return 0;
        }

        if(nums.length == 2){
            return Math.min(nums[0], nums[1]);
        }

        int l = 0;
        int r = nums.length - 1;
        int max = 0;

        while (l < r){
            int h = Math.min(nums[r], nums[l]);
            int w = r - l;
            int area = h * w;
            max = Math.max(max, area);
            if( nums[l] <= nums[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }
}
