package DS.TwoPointers;

import Exception.InvalidInputArgument;

import java.util.HashMap;

/*
Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s
such that every character in t (including duplicates) is included in the window. If there is no such substring,
return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.


Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.


Follow up: Could you find an algorithm that runs in O(m + n) time?


*/

public class MinimumWindowSubstring {
    String s = null;
    String t = null;

    public void acceptInputString(String s) throws Exception {
        if(null == s || s.length() == 0){
            throw new InvalidInputArgument(s);
        }
        this.s = s;
    }

    public void acceptInputPattern(String t) throws Exception {
        if(null == t || t.length() == 0){
            throw new InvalidInputArgument(t);
        }
        this.t = t;
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Input string is null");
        }
        if (s.length() < t.length() || t.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int start = 0;
        int end = 0;
        int charTLeft = t.length();
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;

        while (end < s.length()) {
            char eChar = s.charAt(end);
            if (map.containsKey(eChar)) {
                int count = map.get(eChar);
                if (count > 0) {
                    charTLeft--;
                }
                map.put(eChar, count - 1);
            }
            end++;

            while (charTLeft == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char sChar = s.charAt(start);
                if (map.containsKey(sChar)) {
                    int count = map.get(sChar);
                    if (count == 0) {
                        charTLeft++;
                    }
                    map.put(sChar, count + 1);
                }
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
