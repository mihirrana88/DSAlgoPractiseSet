package DS.Arrays;

import Exception.InvalidInputArgument;

/*
Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

*/

public class RainwaterTrapping {
    public int[] heights = null;

    public void getInputLength(int len){
        heights = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= heights.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        heights[index] = num;
    }

    public int getMaximumWaterCanBeTrapped() throws Exception {
        if(null == heights || heights.length == 0){
            throw new  InvalidInputArgument(heights);
        }

        if(heights.length == 1){
            return 0;
        }

        int l = 0;
        int r = heights.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        int resultant = 0;

        while (l <= r){
            if(heights[l] <= heights[r]){
                if(heights[l] > leftMax){
                    leftMax = heights[l];
                }else {
                    resultant += leftMax - heights[l];
                }

                l++;
            }else {
                if(heights[r] > rightMax){
                    rightMax = heights[r];
                }else {
                    resultant += rightMax - heights[r];
                }

                r--;
            }
        }

        return resultant;
    }
}
