package DS.Strings;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.List;

/*
Stamping The Sequence

You are given two strings stamp and target. Initially, there is a string s of length target.length
with all s[i] == '?'.

In one turn, you can place stamp over s and replace every letter in the s with the corresponding letter from stamp.

For example, if stamp = "abc" and target = "abcba", then s is "?????" initially. In one turn you can:

    place stamp at index 0 of s to obtain "abc??",
    place stamp at index 1 of s to obtain "?abc?", or
    place stamp at index 2 of s to obtain "??abc".

Note that stamp must be fully contained in the boundaries of s in order to stamp
(i.e., you cannot place stamp at index 3 of s).

We want to convert s to target using at most 10 * target.length turns.

Return an array of the index of the left-most letter being stamped at each turn.
If we cannot obtain target from s within 10 * target.length turns, return an empty array.


Example 1:
Input: stamp = "abc", target = "ababc"
Output: [0,2]
Explanation: Initially s = "?????".
- Place stamp at index 0 to get "abc??".
- Place stamp at index 2 to get "ababc".
[1,0,2] would also be accepted as an answer, as well as some other answers.

Example 2:
Input: stamp = "abca", target = "aabcaca"
Output: [3,0,1]
Explanation: Initially s = "???????".
- Place stamp at index 3 to get "???abca".
- Place stamp at index 0 to get "abcabca".
- Place stamp at index 1 to get "aabcaca".


Constraints:

1 <= stamp.length <= target.length <= 1000
stamp and target consist of lowercase English letters.

*/

public class StampingTheSequence {
    String stamp = null;
    String target = null;

    public void acceptInputString(String stamp) throws Exception {
        if(null == stamp || stamp.length() == 0){
            throw new InvalidInputArgument(stamp);
        }
        this.stamp = stamp;
    }

    public void acceptInputPattern(String target) throws Exception {
        if(null == target || target.length() == 0){
            throw new InvalidInputArgument(target);
        }
        this.target = target;
    }

    public int[] movesToStamp(String stamp, String target) {
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();
        boolean[] visited = new boolean[T.length];
        int stars=0;

        List<Integer> res = new ArrayList<>();

        while(stars<T.length){
            boolean replaced = false;
            for(int i=0;i<= T.length - S.length;i++){
                if(!visited[i] && canReplace(T,i,S)){
                    stars = replace(T,i,S.length,stars);
                    replaced = true;
                    visited[i] = true;
                    res.add(i);

                    if(stars == T.length)
                        break;
                }
            }
            if(!replaced)
                return new int[0];
        }

        int ans[] = new int[res.size()];
        for(int i=0;i<res.size();i++)
            ans[i] = res.get(res.size()-i-1);

        return ans;
    }

    private boolean canReplace(char[] T,int p,char[] S){
        for(int i=0;i<S.length;i++)
            if(T[i+p] != '*' && T[i+p] !=S[i])
                return false;
        return true;
    }

    private int replace(char[] T, int p, int len, int count){
        for(int i=0;i<len;i++)
            if(T[p+i] != '*'){
                T[p+i] = '*';
                count++;
            }

        return count;
    }
}
