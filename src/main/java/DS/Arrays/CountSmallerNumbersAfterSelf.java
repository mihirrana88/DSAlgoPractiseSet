package DS.Arrays;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Count of Smaller Numbers After Self

You are given an integer array nums and you have to return a new counts array.
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example 1:
Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Example 2:
Input: nums = [-1]
Output: [0]

Example 3:
Input: nums = [-1,-1]
Output: [0,0]

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

*/

public class CountSmallerNumbersAfterSelf {
    public int[] nums = null;
    private static final int OFFSET = 10001;
    private int[] BIT;

    public void getInputLength(int len){
        nums = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= nums.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        nums[index] = num;
    }

    private void update(int idx){
        idx = idx + OFFSET;
        while(idx < BIT.length){
            BIT[idx]+=1;
            idx += (idx & (-idx));
        }
    }

    private int get(int idx){
        idx = idx + OFFSET;
        int ans = 0;
        while(idx > 0){
            ans+= BIT[idx];
            idx -= (idx & (-idx));
        }
        return ans;
    }

    public List<Integer> countSmaller() {
        BIT = new int[2*OFFSET];
        List<Integer> ans = new ArrayList();
        ans.add(0);
        update(nums[nums.length-1]);

        for(int i = nums.length-2; i>=0 ; i--){
            int curr = nums[i];
            ans.add(get(curr-1));
            update(curr);
        }

        Collections.reverse(ans);
        return ans;

    }
}
