package DS.Maths;

import Exception.InvalidInputArgument;

/*
Count Primes - Sieve of Eratosthenes

Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:

Input: n = 0
Output: 0

Example 3:

Input: n = 1
Output: 0

Constraints:

0 <= n <= 5 * 106

*/

public class SieveOfEratosthenes {
    public Integer inputNumber = null;

    public void acceptInputString(Integer inputNumber) throws Exception {
        if(null == inputNumber){
            throw new InvalidInputArgument(inputNumber);
        }
        this.inputNumber = inputNumber;
    }

    public int getPrimeCount(){
        //array start from 0
        boolean[] primes = new boolean[inputNumber+1];

        if(inputNumber==0 || inputNumber == 1) return 0;

        // false in array here means number is prime
        int count = 0;
        for(int i = 2; i*i <=inputNumber; i++){
            if(!primes[i]){
                for(int j=i*i;j<=inputNumber;j+=i){
                    primes[j] = true;
                }
            }
        }

        for(int i = 2; i<inputNumber; i++){
            if(!primes[i]){
                count++;
            }
        }
        return count;
    }
}
