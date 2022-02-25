package DS.Maths;

import Exception.InvalidInputArgument;

/*
Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104

*/

public class PowerXIsToN {
    public Double x = null;
    public Integer n = null;

    public void acceptInputNumber1(Double n1) throws Exception {
        if(null == n1){
            throw new InvalidInputArgument(n1);
        }
        this.x = n1;
    }

    public void acceptInputNumber2(Integer n2) throws Exception {
        if(null == n2){
            throw new InvalidInputArgument(n2);
        }
        this.n = n2;
    }

    public double powerXisToN() {
        double result = 1;
        double value = x;
        boolean negative = n < 0;
        if( negative ) n = -n;
        while(n != 0) {
            if( (n & 1) == 1 ) result *= value;
            n = n >>> 1;
            value *= value;
        }
        if( negative ) result = 1.0 / result;
        return result;
    }
}
