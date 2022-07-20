package DS.Strings;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented
into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

*/

public class WordBreak {
    public String inputString = null;
    public List<String> wordDict = null;

    private int[] memo;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public void acceptInput(String word){
        if(null == wordDict){
            wordDict = new ArrayList<>();
        }
        wordDict.add(word);
    }

    public boolean wordBreak() {
        memo = new int[inputString.length()];
        Arrays.fill(memo, -1);
        return canBreak(0, inputString, wordDict);
    }

    public boolean canBreak(int start, String s, List<String> wordDict) {
        if (start >= s.length())
            return true;

        if (memo[start] != -1)
        {
            return memo[start] == 1;
        }

        String subs = s.substring(start);
        for (int w = 0; w < wordDict.size(); w++)
        {
            if (subs.startsWith(wordDict.get(w))) {
                // Suppose we took that word!
                boolean result = canBreak(start+wordDict.get(w).length(), s, wordDict);
                if (result)
                {
                    memo[start] = 1;
                    return true;
                }

                // Otherwise it didn't work... try next word
            }
        }
        memo[start] = 0;
        return false;
    }

}
