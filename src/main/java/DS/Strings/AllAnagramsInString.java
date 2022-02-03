package DS.Strings;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.List;

/*
Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's anagrams in s.
You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 
Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.

*/

public class AllAnagramsInString {
    String inputString = null;
    String anagram = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public void acceptInputAnagramWith(String anagram) throws Exception {
        if(null == anagram || anagram.length() == 0){
            throw new InvalidInputArgument(anagram);
        }
        this.anagram = anagram;
    }

    public List<Integer> getAllAnagramsInString() throws Exception {
        List<Integer> allAnagramsStartIndexList = new ArrayList<>();

        if(anagram.length() > inputString.length()){
            return allAnagramsStartIndexList;
        }

        if(anagram.length() == 0){
            return allAnagramsStartIndexList;
        }

        int[] anagramArray = new int[26];
        int[] currentInputArray = new int[26];

        anagramArray = calculateFrequency(anagramArray, anagram);

        for(int i=0; i<anagram.length(); i++){
            currentInputArray[inputString.charAt(i)-'a']++;
        }

        if(isSame(currentInputArray, anagramArray)){
            allAnagramsStartIndexList.add(0);
        }

        for(int i=anagram.length(); i<inputString.length(); i++){
            currentInputArray[inputString.charAt(i-anagram.length()) - 'a']--;
            currentInputArray[inputString.charAt(i) - 'a']++;
            if(isSame(currentInputArray, anagramArray)){
                allAnagramsStartIndexList.add(i-anagram.length()+1);
            }
        }

        return allAnagramsStartIndexList;
    }

    private int[] calculateFrequency(int[] anagramArray, String anagram){
        for(int i=0; i<anagram.length(); i++){
            anagramArray[anagram.charAt(i)- 'a']++;
        }
        return anagramArray;
    }

    private boolean isSame(int[] currentInputArray, int[] anagramArray){
        for(int i=0; i<26; i++){
            if(currentInputArray[i] != anagramArray[i]){
                return false;
            }
        }
        return true;
    }
}
