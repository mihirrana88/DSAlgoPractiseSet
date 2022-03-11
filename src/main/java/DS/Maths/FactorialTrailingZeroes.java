package DS.Maths;

import Exception.InvalidInputArgument;

/*
Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

Example 1:
Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:
Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.

Example 3:
Input: n = 0
Output: 0

Constraints:

0 <= n <= 104

*/

public class FactorialTrailingZeroes {
    public Integer n = null;

    public void acceptInput(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public int getTrailingZeroes() {
        int fives = 0;
        while(n >= 5){
            fives += n / 5;
            n /= 5;
        }
        return fives;
    }

    public int getTrailingZeroesV2(){
        return n/5 + n/25 + n/125 + n/625 + n/3125;
    }
}
