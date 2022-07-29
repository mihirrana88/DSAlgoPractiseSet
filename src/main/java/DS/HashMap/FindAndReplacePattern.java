package DS.HashMap;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Find and Replace Pattern

Given a list of strings words and a string pattern, return a list of words[i] that match pattern.
You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing
every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter,
and no two letters map to the same letter.

Example 1:
Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the
same letter.

Example 2:
Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]


Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.

*/

public class FindAndReplacePattern {
    public String[] words = null;
    String pattern = null;

    public void acceptInput(String input) throws Exception {
        if(null == input || input.length() == 0){
            throw new InvalidInputArgument(input);
        }
        char[] inputCharArray = input.toCharArray();
        this.words = new String[inputCharArray.length];
        for (int i=0; i < inputCharArray.length; i++){
            this.words[i] = String.valueOf(inputCharArray[i]);
        }
    }

    public void acceptInputPattern(String pattern) throws Exception {
        if(null == pattern || pattern.length() == 0){
            throw new InvalidInputArgument(pattern);
        }
        this.pattern = pattern;
    }

    public List<String> findAndReplacePattern() {
        List<String> output = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            if(match(words[i], pattern)){
                output.add(words[i]);
            }
        }

        return output;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> m1 = new HashMap();
        Map<Character, Character> m2 = new HashMap();

        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!m1.containsKey(w)) m1.put(w, p);
            if (!m2.containsKey(p)) m2.put(p, w);
            if (m1.get(w) != p || m2.get(p) != w)
                return false;
        }

        return true;
    }

    private boolean matchWordWithPattern(String word, String pattern){
        Map<Character, Character> M = new HashMap();
        for (int i = 0; i < word.length(); ++i) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!M.containsKey(w)) M.put(w, p);
            if (M.get(w) != p) return false;
        }

        boolean[] seen = new boolean[26];
        for (char p: M.values()) {
            if (seen[p - 'a']) return false;
            seen[p - 'a'] = true;
        }
        return true;
    }
}
