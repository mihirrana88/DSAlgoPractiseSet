package DS.Strings;

import Exception.InvalidInputArgument;

import java.util.ArrayList;
import java.util.List;

/*
Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.

*/

public class PalindromePartitioning {
    String inputString = null;

    public void acceptInputString(String inputString) throws Exception {
        if(null == inputString || inputString.length() == 0){
            throw new InvalidInputArgument(inputString);
        }
        this.inputString = inputString;
    }

    public List<List<String>> partition() {
        List<List<String>> results = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        partitionHelper(results,inputString, result,0);
        return results;
    }

    public void partitionHelper(List<List<String>> results, String s, ArrayList<String> result, int pos){
        if(pos>=s.length()){
            results.add((List<String>)result.clone());
            return;
        }

        for(int i=pos+1;i<=s.length();i++){
            if(isPalindrome(s,pos,i-1)){
                String temp = s.substring(pos,i);
                result.add(temp);
                partitionHelper(results, s, result, i);
                result.remove(result.size()-1);
            }
        }
    }

    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
