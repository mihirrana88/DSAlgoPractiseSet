package DS.Maths;

import Exception.InvalidInputArgument;

/*
Power of Three
Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

Example 1:

Input: n = 27
Output: true

Example 2:

Input: n = 0
Output: false

Example 3:

Input: n = 9
Output: true

Constraints:

-231 <= n <= 231 - 1

*/

public class PowerOfThree {
    public Integer n = null;

    public void acceptInput(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public boolean isPowerOfThree() {
        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfThreeV2() {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
