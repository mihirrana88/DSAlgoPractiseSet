package DS.Maths;

import Exception.InvalidInputArgument;

/*
Power of Four

Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

Example 1:
Input: n = 16
Output: true

Example 2:
Input: n = 5
Output: false

Example 3:
Input: n = 1
Output: true

Constraints:

-231 <= n <= 231 - 1

*/

public class PowerOfFour {
    public Integer n = null;

    public void acceptInput(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public boolean isPowerOfFour(int n) {
        if(n==1) return true;
        if(n<=0) return false;
        double res=Math.log(n)/Math.log(4.0);
        if(res%1==0) return true;
        return false;
    }

    public boolean isPowerOfFourV2(int n) {
        return Integer.bitCount(n) == 1 && Integer.toBinaryString(n).length() % 2 == 1;
    }
}
