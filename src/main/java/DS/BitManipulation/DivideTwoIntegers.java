package DS.BitManipulation;

import Exception.InvalidInputArgument;

/*
Divide Two Integers

Given two integers dividend and divisor, divide two integers without using multiplication, division,
and mod operator.

The integer division should truncate toward zero, which means losing its fractional part.
For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed
integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then
return 231 - 1, and if the quotient is strictly less than -231, then return -231.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.

Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.


Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0

*/

public class DivideTwoIntegers {
    public Integer n1 = null;
    public Integer n2 = null;

    public void acceptInputNumber1(Integer n1) throws Exception {
        if(null == n1){
            throw new InvalidInputArgument(n1);
        }
        this.n1 = n1;
    }

    public void acceptInputNumber2(Integer n2) throws Exception {
        if(null == n2){
            throw new InvalidInputArgument(n2);
        }
        this.n2 = n2;
    }

    public int divisionOfTwoIntegers() {
        int dividend = n1;
        int divisor = n2;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        int signum = 1;
        if (dividend > 0 && divisor > 0) {
            dividend = -dividend;
            divisor = -divisor;
        } else if (dividend < 0 && divisor > 0) {
            signum = -1;
            divisor = -divisor;
        } else if (dividend > 0 && divisor < 0) {
            signum = -1;
            dividend = -dividend;
        }

        int result = divideInNegative(dividend, divisor);
        return signum > 0 ? -result : result;
    }

    private int divideInNegative(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }
        int result = -1;
        int shiftedDivisor = divisor;
        while (dividend < shiftedDivisor) {
            int t = shiftedDivisor << 1;
            if (t < 0) { //check overflow
                shiftedDivisor = t;
                result <<= 1;
            } else {
                break;
            }
        }

        if (dividend > shiftedDivisor) {
            result >>= 1;
            shiftedDivisor >>= 1;
        }

        int rest = divideInNegative(dividend - shiftedDivisor, divisor);
        return result + rest;
    }
}
