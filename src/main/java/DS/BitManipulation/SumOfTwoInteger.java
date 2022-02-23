package DS.BitManipulation;

import Exception.InvalidInputArgument;

/*
Sum of Two Integers

Given two integers a and b, return the sum of the two integers without using the operators + and -.

Example 1:

Input: a = 1, b = 2
Output: 3

Example 2:

Input: a = 2, b = 3
Output: 5

Constraints:

-1000 <= a, b <= 1000

*/

public class SumOfTwoInteger {
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

    public int getSumOfTwoInteger() {
        while(n2!=0){
            int temp=(n1&n2)<<1;
            n1=n1^n2;
            n2=temp;
        }
        return n1;
    }
}
