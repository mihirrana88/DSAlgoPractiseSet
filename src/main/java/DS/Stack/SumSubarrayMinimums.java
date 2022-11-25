package DS.Stack;

import java.util.Stack;

/*
Sum of Subarray Minimums

Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous)
subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

Example 1:
Input: arr = [3,1,2,4]
Output: 17
Explanation:
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.

Example 2:
Input: arr = [11,81,94,43,3]
Output: 444

Constraints:

1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104

*/

public class SumSubarrayMinimums {
    public int[] arr = null;

    public void getInputLength(int len){
        arr = new int[len];
    }

    public void acceptInput(int num, int index){
        if(index < 0 || index >= arr.length){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        arr[index] = num;
    }

    public int sumSubarrayMins() {
        int MOD = 1000000007;

        Stack<Integer> stack = new Stack<>();

        // make a dp array of the same size as the input array `arr`
        int[] dp = new int[arr.length];

        // making a monotonic increasing stack
        for (int i = 0; i < arr.length; i++) {
            // pop the stack until it is empty or
            // the top of the stack is greater than or equal to
            // the current element
            while (!stack.empty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            // either the previousSmaller element exists
            if (stack.size() > 0) {
                int previousSmaller = stack.peek();
                dp[i] = dp[previousSmaller] + (i - previousSmaller) * arr[i];
            } else {
                // or it doesn't exist, in this case the current element
                // contributes with all subarrays ending at i
                dp[i] = (i + 1) * arr[i];
            }
            // push the current index
            stack.push(i);
        }

        // Add all elements of the dp to get the answer
        long sumOfMinimums = 0;
        for (int count : dp) {
            sumOfMinimums += count;
            sumOfMinimums %= MOD;
        }

        return (int) sumOfMinimums;
    }
}
