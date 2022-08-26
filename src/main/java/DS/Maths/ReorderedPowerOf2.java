package DS.Maths;

import Exception.InvalidInputArgument;

import java.util.Arrays;

/*
Reordered Power of 2

You are given an integer n. We reorder the digits in any order (including the original order) such that the
leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

Example 1:
Input: n = 1
Output: true

Example 2:
Input: n = 10
Output: false

Constraints:

1 <= n <= 109

*/

public class ReorderedPowerOf2 {
    public Integer n = null;

    public void acceptInput(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public boolean reorderedPowerOf2(int n) {
        int[] A = count(n);
        for (int i = 0; i < 31; ++i)
            if (Arrays.equals(A, count(1 << i)))
                return true;
        return false;
    }

    public int[] count(int N) {
        int[] ans = new int[10];
        while (N > 0) {
            ans[N % 10]++;
            N /= 10;
        }
        return ans;
    }
}
