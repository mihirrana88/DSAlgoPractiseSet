package DS.Stack;

import Exception.InvalidInputArgument;

import java.util.Stack;

/*
Largest Rectangle in Histogram

Given an array of integers heights representing the histogram's bar height where the width of
each bar is 1, return the area of the largest rectangle in the histogram.


Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104

*/

public class LargestRectangleHistogram {
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

    public int getLargestRectangleInHistogram() throws Exception {
        if(null == nums || nums.length == 0){
            throw new InvalidInputArgument(nums);
        }

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0;
        for(int i = 0 ; i <= nums.length ; i++){
            int ht = (i == nums.length) ? 0 : nums[i];

            while(st.peek() != -1  &&  ht <=  nums[st.peek()]){
                int idx = st.pop();
                int rm = i;
                int lm = st.peek();
                int area = nums[idx] * (rm - lm -1);
                ans = Math.max(ans,area);
            }
            st.push(i);

        }
        return ans;
    }
}
