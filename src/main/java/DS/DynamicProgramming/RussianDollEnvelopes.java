package DS.DynamicProgramming;

import Exception.InvalidInputArgument;

import java.util.Arrays;

/*
Russian Doll Envelopes

You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi]
represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater
than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

Example 1:

Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

Example 2:

Input: envelopes = [[1,1],[1,1],[1,1]]
Output: 1

Constraints:

1 <= envelopes.length <= 105
envelopes[i].length == 2
1 <= wi, hi <= 105

*/

public class RussianDollEnvelopes {
    int[][] envelopes = null;

    public void getInputLength(int row, int column){
        envelopes = new int[row][column];
    }

    public void acceptInput(int num, int row, int column){
        if(row < 0 || column < 0 || row > envelopes.length-1 || column > envelopes[0].length){
            throw new ArrayIndexOutOfBoundsException("row="+row+" and column="+column);
        }
        envelopes[row][column] = num;
    }

    public int maxEnvelopes() {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int ans = 0;
        for (int[] env : envelopes) {
            int height = env[1];
            int left = Arrays.binarySearch(dp, 0, ans, height);
            if (left < 0) left = -left - 1;
            if (left == ans) ans++;
            dp[left] = height;
        }
        return ans;
    }
}
