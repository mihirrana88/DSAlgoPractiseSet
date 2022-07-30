package DS.HashMap;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.List;

/*
Word Subsets

You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.

Example 1:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]

Example 2:
Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]

Constraints:

1 <= words1.length, words2.length <= 104
1 <= words1[i].length, words2[i].length <= 10
words1[i] and words2[i] consist only of lowercase English letters.
All the strings of words1 are unique.

*/

public class WordSubsets {
    public String[] words1 = null;
    public String[] words2 = null;

    public void acceptWords1(String input) throws Exception {
        if(null == input || input.length() == 0){
            throw new InvalidInputArgument(input);
        }
        char[] inputCharArray = input.toCharArray();
        this.words1 = new String[inputCharArray.length];
        for (int i=0; i < inputCharArray.length; i++){
            this.words1[i] = String.valueOf(inputCharArray[i]);
        }
    }

    public void acceptWords2(String input) throws Exception {
        if(null == input || input.length() == 0){
            throw new InvalidInputArgument(input);
        }
        char[] inputCharArray = input.toCharArray();
        this.words2 = new String[inputCharArray.length];
        for (int i=0; i < inputCharArray.length; i++){
            this.words2[i] = String.valueOf(inputCharArray[i]);
        }
    }

    public List<String> wordSubsets() {
        int[] bmax = count("");
        for (String b: words2) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        search: for (String a: words1) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i)
                if (aCount[i] < bmax[i])
                    continue search;
            ans.add(a);
        }

        return ans;
    }

    private int[] count(String S) {
        int[] ans = new int[26];
        for (char c: S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}
