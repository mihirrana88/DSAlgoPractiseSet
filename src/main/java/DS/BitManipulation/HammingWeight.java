package DS.BitManipulation;

import Exception.InvalidInputArgument;

/*
Number of 1 Bits

Write a function that takes an unsigned integer and returns the number of '1' bits it has
(also known as the Hamming weight).

Note:

Note that in some languages, such as Java, there is no unsigned integer type.
In this case, the input will be given as a signed integer type. It should not affect your implementation,
as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore,
in Example 3, the input represents the signed integer. -3.

Example 1:

Input: n = 11
Output: 3

Example 2:

Input: n = 128
Output: 1

*/

public class HammingWeight {
    public Integer n = null;

    public void acceptInput(Integer n) throws Exception {
        if(null == n){
            throw new  InvalidInputArgument(n);
        }
        this.n = n;
    }

    public int getHammingWeight() {
        int hammingWeight = 0;
        while (n != 0){
            n = n & (n-1);
            hammingWeight++;
        }
        return hammingWeight;
    }
}
