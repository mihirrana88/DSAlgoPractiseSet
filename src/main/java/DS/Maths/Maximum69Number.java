package DS.Maths;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.List;

/*
Maximum 69 Number

You are given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

Example 1:

Input: num = 9669
Output: 9969
Explanation:
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.

Example 2:
Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.

Example 3:
Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.

Constraints:

1 <= num <= 104
num consists of only 6 and 9 digits.

*/

public class Maximum69Number {
    public Integer n = null;

    public void acceptInput(Integer n) throws Exception {
        if(null == n){
            throw new InvalidInputArgument(n);
        }
        this.n = n;
    }

    public int maximum69Number (int num) {

        List<Integer> list = new ArrayList<>();

        while(num > 0){
            int digit = num%10;
            list.add(digit);
            num = num/10;
        }

        int ans = 0;
        boolean flag = true;
        for(int i=list.size()-1; i>=0; i--){
            int digit = list.get(i);
            if(digit == 6 && flag){
                digit = 9;
                flag = false;
            }
            ans = ans * 10 + digit;
        }

        return ans;
    }
}
